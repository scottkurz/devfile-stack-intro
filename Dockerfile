# Step 1: Build the user's application
#FROM ajymau/java-openliberty-odo:0.1.3 as compile

# Make a well known place for shared library jars seperate from the rest of the defaultServer contents (to help with caching)
#RUN mkdir /configlibdir \
#   && mkdir /config \
#   &&  mkdir /shared


# Copy the rest of the application source
#COPY ./src /project/user-app/src
#COPY ./pom.xml /project/user-app/pom.xml

# Build (and run unit tests) 
#  also liberty:create copies config from src->target
#  also remove quick-start-security.xml since it's convenient for local dev mode but should not be in the production image.
#RUN cd /project/user-app && \
#    echo "QUICK START SECURITY IS NOT SECURE FOR PRODUCTION ENVIRONMENTS. IT IS BEING REMOVED" && \
#    rm -f src/main/liberty/config/configDropins/defaults/quick-start-security.xml && \
#    mvn liberty:create package

# process any resources or shared libraries - if they are present in the dependencies block for this project (there may be none potentially)
# test to see if each is present and move to a well known location for later processing in the next stage
# 
#RUN cd /project/user-app/target/liberty/wlp/usr/servers && \
#    if [ -d ./defaultServer/lib ]; then mv ./defaultServer/lib /configlibdir; fi && \
#    if [ ! -d /configlibdir/lib ]; then mkdir /configlibdir/lib; fi && \
#    mv -f defaultServer/* /config/ && \
#    if [ -d ../shared ]; then mv ../shared/* /shared/; fi
#
# Step 2: Package Open Liberty image
FROM openliberty/open-liberty:20.0.0.9-kernel-java11-openj9-ubi


#
# 1. Could use copyDependencies to make these hold something, for now uncomment only if they do
#

#COPY target/liberty/wlp/usr/shared /opt/ol/wlp/usr/shared/
#COPY target/liberty/wlp/usr/servers/defaultServer/lib /opt/ol/wlp/usr/servers/defaultServer/lib

#COPY --chown=1001:0 target/liberty/wlp/usr/servers/defaultServer/server.env /config
#COPY --chown=1001:0 target/liberty/wlp/usr/servers/defaultServer/configDropins/defaults/quick-start-security.xml /config/configDropins/defaults
#COPY --chown=1001:0 target/liberty/wlp/usr/servers/defaultServer/configDropins/defaults/system-test-vars.xml  /config/configDropins/defaults
COPY --chown=1001:0 target/liberty/wlp/usr/servers/defaultServer/configDropins/defaults /config/configDropins
COPY --chown=1001:0 target/liberty/wlp/usr/servers/defaultServer/configDropins/overrides/liberty-plugin-variable-config.xml   /config/configDropins/overrides/liberty-plugin-variable-config.xml
COPY --chown=1001:0 target/liberty/wlp/usr/servers/defaultServer/* /config/


# 2d) Changes to the application binary
COPY target/simple-jaxrs.war /config/apps
RUN configure.sh 

# 2. don't delete on exit
