INSERT INTO users (username, password, role)
SELECT 'nesrin', 'nesrin123', 'USER'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'nesrin');

INSERT INTO users (username, password, role)
SELECT 'seda', 'seda123', 'USER'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'seda');
