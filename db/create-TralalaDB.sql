CREATE DATABASE tralaladb;

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP,INDEX, REFERENCES
           ON tralaladb.*
           TO sd@'%'
           IDENTIFIED BY 'sd';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP,INDEX, REFERENCES
           ON tralaladb.*
           TO sd@localhost
           IDENTIFIED BY 'sd';