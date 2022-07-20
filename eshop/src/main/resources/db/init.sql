INSERT INTO PRODUCT (id, name, description, price) VALUES
    ('00000000-0000-0000-0000-000000000001', 'iPhone 23', 'Naujausias iPhone!', 5005.99),
    ('00000000-0000-0000-0000-000000000002', 'Samsung S55', 'Naujausias Samsung!', 4999.99),
    ('00000000-0000-0000-0000-000000000003', 'Nokia 3310', 'Seniausia Nokia!', 10.99),
    ('00000000-0000-0000-0000-000000000004', 'Huawei Mate', 'Kazkoks Huawei!', 15.99),
    ('00000000-0000-0000-0000-000000000005', 'Xiaomi Mi', 'Kazkokie Mi!', 100.12),
    ('00000000-0000-0000-0000-000000000006', 'Sony Xperia', 'Sony!!!', 1001.00),
    ('00000000-0000-0000-0000-000000000007', 'Samsung S55', 'Naujausias Samsung!', 4999.99),
    ('00000000-0000-0000-0000-000000000008', 'Samsung S55', 'Naujausias Samsung!', 4999.99),
    ('00000000-0000-0000-0000-000000000009', 'Samsung S55', 'Naujausias Samsung!', 4999.99),
    ('00000000-0000-0000-0000-000000000010', 'Samsung S55', 'Naujausias Samsung!', 4999.99),
    ('00000000-0000-0000-0000-000000000011', 'Samsung S55', 'Naujausias Samsung!', 4999.99),
    ('00000000-0000-0000-0000-000000000012', 'Samsung S55', 'Naujausias Samsung!', 4999.99),
    ('00000000-0000-0000-0000-000000000013', 'Samsung S55', 'Naujausias Samsung!', 4999.99),
    ('00000000-0000-0000-0000-000000000014', 'Samsung S55', 'Naujausias Samsung!', 4999.99)
    ;

INSERT INTO Users VALUES
    ('user', 'Useris', '{bcrypt}$2a$12$GtVeSIV16y1OOBdYJES5HOIJkxWBLNKDlqqSt7iz0TVg0..XE3nb6', 'Useriauskas'), /* password=pass */
    ('admin', 'Adminas', '{bcrypt}$2a$12$b8PbmpdeCXu5HOQPWDOmveN9TsX9T/czvtL5hOEAvpZM1.DFKjmEW', 'Adminiauskas'); /* password=admin */

INSERT INTO Role VALUES
    ('USER'),
    ('ADMIN');

INSERT INTO users_roles VALUES
    ('user', 'USER'),
    ('admin', 'USER'),
    ('admin', 'ADMIN');
