# openshift-tutorial
Questo progetto include un semplice servizio REST, corredato della configurazione necessaria a essere deployato come microservizio su un ambiente OpenShift.

Per effettuare il deploy in un nuovo progetto, eseguire:

    oc login
    oc new-project tutorial
    oc new-app docker.io/fabric8/s2i-java~https://github.com/giambeppo/openshift-tutorial.git

Una volta che la build è completata, accedere alla console web di OpenShift ed eseguire le seguenti operazioni:
- individuare il deployment `openshift-tutorial` e modificare il descrittore YAML modificando il `campo spec.template.spec.containers.ports` come segue:
```
ports:
    -
        containerPort: 8778
        protocol: TCP
    -
        containerPort: 8080
        protocol: TCP
```
- individuare il servizio `openshift-tutorial` e modificare il descrittore YAML modificando il campo `spec.ports` come segue:
```
ports:
    -
        name: 8778-tcp
        protocol: TCP
        port: 8778
        targetPort: 8778
    -
        name: 8080-tcp
        protocol: TCP
        port: 8080
        targetPort: 8080
```
- creare una nuova route con nome `openshift-tutorial`, che punta al servizio `openshift-tutorial` e alla porta 8080

A questo punto, il servizio risponderà alla url http://openshift-tutorial-tutorial.rhel-cdk.10.1.2.2.xip.io/ciao (sostituire l'hostname con quello generato della propria route, se necessario).