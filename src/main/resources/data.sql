TRUNCATE formule CASCADE;
TRUNCATE garantie CASCADE;
TRUNCATE assure CASCADE;
TRUNCATE remboursement CASCADE;

INSERT INTO formule (id, libelle, mensualite)
VALUES (1, 'eco', 20),
       (2, 'medium', 50),
       (3, 'premium', 100);

INSERT INTO garantie (id, formule_id, type_soin, taux_remboursement)
VALUES (1, 1, 'optique', 0.1),
       (2, 1, 'dentaire', 0.11),
       (3, 1, 'chirurgie', 0.12),
       (4, 1, 'orthopedie', 0.15),
       (5, 2, 'optique', 0.21),
       (6, 2, 'dentaire', 0.25),
       (7, 2, 'chirurgie', 0.25),
       (8, 2, 'orthopedie', 0.28),
       (9, 3, 'optique', 0.32),
       (10, 3, 'dentaire', 0.32),
       (11, 3, 'chirurgie', 0.33),
       (12, 3, 'orthopedie', 0.35);

INSERT INTO assure (id, prenom, nom, email, iban, nir, is_active, formule_id)
VALUES (1, 'Jean', 'DUPONT', 'jean.dupont@mail.com', 'FR7610107001011234567890129', 1234567891234, true, 1),
       (2, 'Thomas', 'SMITH', 'thomas.smith@mail.com', 'FR7610107001011234567890130', 1234567891235, false,2),
       (3, 'Marie', 'LEROY', 'marie.leroy@mail.com', 'FR7630006000011234567890140', 2345678901234, true,3),
       (4, 'Lucas', 'MARTIN', 'lucas.martin@mail.com', 'FR7630006000011234567890141', 1890567234567,true, 1),
       (5, 'Sophie', 'BERNARD', 'sophie.bernard@mail.com', 'FR7630006000011234567890142', 2901234567890, true,2),
       (6, 'Pierre', 'MOREAU', 'pierre.moreau@mail.com', 'FR7630006000011234567890143', 1780345678901, true,3),
       (7, 'Camille', 'PETIT', 'camille.petit@mail.com', 'FR7630006000011234567890144', 2670456789012, true,1),
       (8, 'Antoine', 'ROBERT', 'antoine.robert@mail.com', 'FR7630006000011234567890145', 1560567890123, true,2),
       (9, 'Julie', 'RICHARD', 'julie.richard@mail.com', 'FR7630006000011234567890146', 2450678901234, true,3),
       (10, 'Nicolas', 'DURAND', 'nicolas.durand@mail.com', 'FR7630006000011234567890147', 1340789012345, true,1),
       (11, 'Emma', 'GARCIA', 'emma.garcia@mail.com', 'FR7630006000011234567890148', 2230890123456, false,2),
       (12, 'Hugo', 'ROUX', 'hugo.roux@mail.com', 'FR7630006000011234567890149', 1120901234567, true,3),
       (13, 'Lea', 'FOURNIER', 'lea.fournier@mail.com', 'FR7630006000011234567890150', 2011012345678, true,1),
       (14, 'Maxime', 'GIRARD', 'maxime.girard@mail.com', 'FR7630006000011234567890151', 1950123456789, true,2),
       (15, 'Clara', 'BONNET', 'clara.bonnet@mail.com', 'FR7630006000011234567890152', 2840234567890, false,3);

INSERT INTO remboursement (assure_id, date_soin, type_soin, montant_facture, part_mutuelle)
VALUES (1, '2026-01-01', 'optique', 242.85, 0.5),
       (1, '2026-01-02', 'dentaire', 1500.50, 0.2),
       (1, '2026-01-03', 'orthopedie', 75.55, 0.3);