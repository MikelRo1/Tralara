CREATE DATABASE proyectotralala;

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP,INDEX, REFERENCES
           ON ptoyectotralala.*
           TO sd@'%'
           IDENTIFIED BY 'sd';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP,INDEX, REFERENCES
           ON proyectotralala.*
           TO sd@localhost
           IDENTIFIED BY 'sd';