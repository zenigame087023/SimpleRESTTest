DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id VARCHAR(6) PRIMARY KEY,
  name VARCHAR(20) NOT NULL,
  department_id VARCHAR(4) NOT NULL,
  age INT NOT NULL,
  gender VARCHAR(1) NOT NULL,
  telephone_no VARCHAR(20) NOT NULL,
  address VARCHAR(120) NOT NULL,
  create_time TIMESTAMP NOT NULL,
  last_update TIMESTAMP AS NOW()
);

INSERT INTO employee (id, name, department_id, age, gender
  ,telephone_no ,address ,create_time) VALUES
  ('E00001','謝永強', 'D001', 22, 'M' ,'0913000000', 'OO市XX區OO里XX路250號',{ts '2020-01-01 00:00:00.00'}),
  ('E00002','劉長貴', 'D001', 23, 'M' ,'0913000002', 'OO市XX區OO里SS路258號',{ts '2020-01-01 00:00:00.00'}),
  ('E00003','劉英', 'D002', 22, 'F' ,'0913000003', 'OO市XX區OO里XX路250號',{ts '2020-01-01 00:00:00.00'}),
  ('E00004','謝大腳', 'D003', 60, 'F' ,'0913000007', 'OO市XX區OO里XX路250號',{ts '2020-01-01 00:00:00.00'}),
  ('E00005','王大拿', 'D003', 65, 'M' ,'0913000008', 'OO市XX區OO里XX路257號',{ts '2020-01-01 00:00:00.00'}),
  ('E00006','皮長三', 'D004', 42, 'M' ,'0913000009', 'OO市XX區OO里dd路260號',{ts '2020-01-01 00:00:00.00'});

DROP TABLE IF EXISTS department;

CREATE TABLE department (
  id VARCHAR(4) PRIMARY KEY,
  name VARCHAR(20) NOT NULL
);

INSERT INTO department (id, name) VALUES
  ('D001', '業務部'),('D002', '會計部'),('D003', '人事部'),('D004', '法務部');