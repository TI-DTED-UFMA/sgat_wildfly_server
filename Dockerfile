FROM jboss/base-jdk:8

USER root

ENV LAUNCH_JBOSS_IN_BACKGROUND true

CMD ["sh","/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0","-bmanagement","0.0.0.0"]
