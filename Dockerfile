FROM openjdk:11 as builder

RUN --mount=type=bind,src=.,dst=/usr/src/presto-iris,rw \
    --mount=type=cache,target=/root/.m2 \
    cd /usr/src/presto-iris && \
    ./mvnw package && \
    mkdir /tmp/presto-iris && \
    cp target/presto-iris-*-plugin.tar.gz /tmp/presto-iris/presto-iris-plugin.tar.gz

FROM prestodb/presto

RUN --mount=type=bind,from=builder,src=/tmp/presto-iris,dst=/tmp/presto-iris \
    mkdir /opt/presto-server/plugin/iris/ && \
    tar -zxvf /tmp/presto-iris/presto-iris-plugin.tar.gz -C /opt/presto-server/plugin/iris/ --strip-components=1

