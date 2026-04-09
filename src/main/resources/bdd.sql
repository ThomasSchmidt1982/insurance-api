DROP TABLE IF EXISTS formule CASCADE ;
DROP TABLE IF EXISTS garantie CASCADE ;
DROP TABLE IF EXISTS assure CASCADE ;
DROP TABLE IF EXISTS remboursement CASCADE ;

CREATE TABLE formule (
                         id SERIAL PRIMARY KEY,
                         libelle VARCHAR(100) NOT NULL,
                         mensualite DECIMAL(8,2) NOT NULL
);

CREATE TABLE garantie (
                          id SERIAL PRIMARY KEY,
                          type_soin VARCHAR(50) NOT NULL,
                          taux_remboursement DECIMAL(5,2) NOT NULL,
                          formule_id INT NOT NULL REFERENCES formule(id)

);

CREATE TABLE assure (
                        id SERIAL PRIMARY KEY,
                        prenom VARCHAR(100) NOT NULL,
                        nom VARCHAR(100) NOT NULL,
                        email VARCHAR(150) NOT NULL UNIQUE ,
                        iban VARCHAR(34) NOT NULL UNIQUE ,
                        nir VARCHAR(150) NOT NULL UNIQUE ,
                        is_active BOOLEAN NOT NULL ,
                        formule_id INT NOT NULL REFERENCES formule(id)
);

CREATE TABLE remboursement (
                               id SERIAL PRIMARY KEY,
                               date_soin TIMESTAMP NOT NULL,
                               type_soin VARCHAR(50) NOT NULL,
                               montant_facture DECIMAL(8,2) NOT NULL,
                               part_mutuelle DECIMAL(8,2),
                               assure_id INT NOT NULL REFERENCES assure(id)
);