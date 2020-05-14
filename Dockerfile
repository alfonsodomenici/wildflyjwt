FROM airhacks/glassfish
COPY ./target/jwtpayara.war ${DEPLOYMENT_DIR}
