--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.6
-- Dumped by pg_dump version 9.3.6
-- Started on 2015-08-10 15:49:44

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

DROP DATABASE hrms_db;
--
-- TOC entry 2015 (class 1262 OID 41084)
-- Name: hrms_db; Type: DATABASE; Schema: -; Owner: hrms_user
--

CREATE DATABASE hrms_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE hrms_db OWNER TO hrms_user;

\connect hrms_db

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 7 (class 2615 OID 49370)
-- Name: hrms; Type: SCHEMA; Schema: -; Owner: hrms_user
--

CREATE SCHEMA hrms;


ALTER SCHEMA hrms OWNER TO hrms_user;

--
-- TOC entry 6 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2016 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 183 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2018 (class 0 OID 0)
-- Dependencies: 183
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = hrms, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 49371)
-- Name: hiv_risk; Type: TABLE; Schema: hrms; Owner: hrms_user; Tablespace: 
--

CREATE TABLE hiv_risk (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    parent_id bigint,
    has_children boolean
);


ALTER TABLE hrms.hiv_risk OWNER TO hrms_user;

--
-- TOC entry 172 (class 1259 OID 49374)
-- Name: hiv_risk_id_seq; Type: SEQUENCE; Schema: hrms; Owner: hrms_user
--

CREATE SEQUENCE hiv_risk_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hrms.hiv_risk_id_seq OWNER TO hrms_user;

--
-- TOC entry 2019 (class 0 OID 0)
-- Dependencies: 172
-- Name: hiv_risk_id_seq; Type: SEQUENCE OWNED BY; Schema: hrms; Owner: hrms_user
--

ALTER SEQUENCE hiv_risk_id_seq OWNED BY hiv_risk.id;


--
-- TOC entry 173 (class 1259 OID 49376)
-- Name: patient; Type: TABLE; Schema: hrms; Owner: hrms_user; Tablespace: 
--

CREATE TABLE patient (
    id bigint NOT NULL,
    first_name character varying(255) NOT NULL,
    middle_name character varying(255),
    last_name character varying(255) NOT NULL,
    sex character varying(50) NOT NULL,
    unique_id_code character varying(255) NOT NULL,
    birthdate date NOT NULL,
    mom_first_name character varying(255),
    mom_middle_name character varying(255),
    mom_last_name character varying(255),
    address character varying(255),
    city character varying(255),
    contact_number character varying(50),
    created_by bigint NOT NULL,
    updated_by bigint,
    created_date timestamp without time zone NOT NULL,
    updated_date timestamp without time zone
);


ALTER TABLE hrms.patient OWNER TO hrms_user;

--
-- TOC entry 174 (class 1259 OID 49382)
-- Name: patient_hiv_risk; Type: TABLE; Schema: hrms; Owner: hrms_user; Tablespace: 
--

CREATE TABLE patient_hiv_risk (
    patient_id bigint NOT NULL,
    hiv_risk_id bigint NOT NULL
);


ALTER TABLE hrms.patient_hiv_risk OWNER TO hrms_user;

--
-- TOC entry 175 (class 1259 OID 49385)
-- Name: patient_id_seq; Type: SEQUENCE; Schema: hrms; Owner: hrms_user
--

CREATE SEQUENCE patient_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hrms.patient_id_seq OWNER TO hrms_user;

--
-- TOC entry 2020 (class 0 OID 0)
-- Dependencies: 175
-- Name: patient_id_seq; Type: SEQUENCE OWNED BY; Schema: hrms; Owner: hrms_user
--

ALTER SEQUENCE patient_id_seq OWNED BY patient.id;


--
-- TOC entry 176 (class 1259 OID 49387)
-- Name: role; Type: TABLE; Schema: hrms; Owner: hrms_user; Tablespace: 
--

CREATE TABLE role (
    id bigint NOT NULL,
    code character varying(55) NOT NULL,
    name character varying(255)
);


ALTER TABLE hrms.role OWNER TO hrms_user;

--
-- TOC entry 177 (class 1259 OID 49390)
-- Name: role_id_seq; Type: SEQUENCE; Schema: hrms; Owner: hrms_user
--

CREATE SEQUENCE role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hrms.role_id_seq OWNER TO hrms_user;

--
-- TOC entry 2021 (class 0 OID 0)
-- Dependencies: 177
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: hrms; Owner: hrms_user
--

ALTER SEQUENCE role_id_seq OWNED BY role.id;


--
-- TOC entry 178 (class 1259 OID 49392)
-- Name: user; Type: TABLE; Schema: hrms; Owner: hrms_user; Tablespace: 
--

CREATE TABLE "user" (
    id bigint NOT NULL,
    first_name character varying(255) NOT NULL,
    middle_name character varying(255),
    last_name character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    username character varying(255) NOT NULL
);


ALTER TABLE hrms."user" OWNER TO hrms_user;

--
-- TOC entry 179 (class 1259 OID 49398)
-- Name: user_id_seq; Type: SEQUENCE; Schema: hrms; Owner: hrms_user
--

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hrms.user_id_seq OWNER TO hrms_user;

--
-- TOC entry 2022 (class 0 OID 0)
-- Dependencies: 179
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: hrms; Owner: hrms_user
--

ALTER SEQUENCE user_id_seq OWNED BY "user".id;


--
-- TOC entry 180 (class 1259 OID 49400)
-- Name: user_role; Type: TABLE; Schema: hrms; Owner: hrms_user; Tablespace: 
--

CREATE TABLE user_role (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE hrms.user_role OWNER TO hrms_user;

--
-- TOC entry 181 (class 1259 OID 49403)
-- Name: vct; Type: TABLE; Schema: hrms; Owner: hrms_user; Tablespace: 
--

CREATE TABLE vct (
    id bigint NOT NULL,
    patient_id bigint NOT NULL,
    vct_date date NOT NULL,
    is_hiv_tested smallint,
    is_hiv_positive smallint,
    reason_for_not_testing character varying(255),
    provided_counseling_and_result smallint,
    created_by bigint NOT NULL,
    updated_by bigint,
    created_date timestamp without time zone NOT NULL,
    updated_date timestamp without time zone
);


ALTER TABLE hrms.vct OWNER TO hrms_user;

--
-- TOC entry 182 (class 1259 OID 49406)
-- Name: vct_id_seq; Type: SEQUENCE; Schema: hrms; Owner: hrms_user
--

CREATE SEQUENCE vct_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hrms.vct_id_seq OWNER TO hrms_user;

--
-- TOC entry 2023 (class 0 OID 0)
-- Dependencies: 182
-- Name: vct_id_seq; Type: SEQUENCE OWNED BY; Schema: hrms; Owner: hrms_user
--

ALTER SEQUENCE vct_id_seq OWNED BY vct.id;


--
-- TOC entry 1858 (class 2604 OID 49408)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY hiv_risk ALTER COLUMN id SET DEFAULT nextval('hiv_risk_id_seq'::regclass);


--
-- TOC entry 1859 (class 2604 OID 49409)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY patient ALTER COLUMN id SET DEFAULT nextval('patient_id_seq'::regclass);


--
-- TOC entry 1860 (class 2604 OID 49410)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY role ALTER COLUMN id SET DEFAULT nextval('role_id_seq'::regclass);


--
-- TOC entry 1861 (class 2604 OID 49411)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


--
-- TOC entry 1862 (class 2604 OID 49412)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY vct ALTER COLUMN id SET DEFAULT nextval('vct_id_seq'::regclass);


--
-- TOC entry 1999 (class 0 OID 49371)
-- Dependencies: 171
-- Data for Name: hiv_risk; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO hiv_risk (id, name, parent_id, has_children) VALUES (1, 'Blood Transfusion (BT) Recipient', NULL, false);
INSERT INTO hiv_risk (id, name, parent_id, has_children) VALUES (2, 'Injecting Drug User (IDU)', NULL, false);
INSERT INTO hiv_risk (id, name, parent_id, has_children) VALUES (3, 'Substance Abuse', NULL, false);
INSERT INTO hiv_risk (id, name, parent_id, has_children) VALUES (4, 'Occupational Exposure (OE)', NULL, false);
INSERT INTO hiv_risk (id, name, parent_id, has_children) VALUES (5, 'Sexually Transmitted Infections (STI)', NULL, false);
INSERT INTO hiv_risk (id, name, parent_id, has_children) VALUES (6, 'Multiple Sexual Partners', NULL, false);
INSERT INTO hiv_risk (id, name, parent_id, has_children) VALUES (7, 'Male having Sex with other Males (MSM)', NULL, false);
INSERT INTO hiv_risk (id, name, parent_id, has_children) VALUES (8, 'Client of a Sex Worker', NULL, false);
INSERT INTO hiv_risk (id, name, parent_id, has_children) VALUES (9, 'Sex Worker', NULL, false);
INSERT INTO hiv_risk (id, name, parent_id, has_children) VALUES (10, 'Child of HIV Infected Mother', NULL, false);
INSERT INTO hiv_risk (id, name, parent_id, has_children) VALUES (12, 'Provided Post Exposure Prophylaxis___Yes', 11, false);
INSERT INTO hiv_risk (id, name, parent_id, has_children) VALUES (13, 'Provided Post Exposure Prophylaxis___No', 11, false);
INSERT INTO hiv_risk (id, name, parent_id, has_children) VALUES (11, 'Occupational Exposure (OE)', NULL, true);


--
-- TOC entry 2024 (class 0 OID 0)
-- Dependencies: 172
-- Name: hiv_risk_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('hiv_risk_id_seq', 13, true);


--
-- TOC entry 2001 (class 0 OID 49376)
-- Dependencies: 173
-- Data for Name: patient; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (3, 'Rey', 'Patigas', 'Libutan', 'MALE', 'XX-YY-99', '1992-06-27', 'Belle', 'Cerna', 'Patigas', 'Deca Homes Baywalk, Brgy. Dumlog', 'Talisay City', '09432935645', 1, NULL, '2015-08-03 23:06:52.275', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (4, 'Rey', 'Patigas', 'Libutan', 'MALE', 'XX-YY-99', '2015-08-26', '', '', '', '', '', '', 1, NULL, '2015-08-04 23:57:35.171', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (5, 'Rey', 'Patigas', 'Libutan', 'MALE', 'XX-YY-99', '1992-06-27', '', '', '', '', '', '', 1, NULL, '2015-08-04 23:59:30.411', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (7, 'Jin', '', 'Kazama', 'MALE', 'JJ-KK-99', '1982-08-10', 'Jun', '', 'Kazama', 'Mishima Corporation, Japan', 'Tokyo', '09992748562', 1, NULL, '2015-08-10 15:31:46.099', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (8, 'Lee', '', 'Chaolan', 'MALE', 'LL-CC-99', '1929-09-02', 'Alisa', '', 'Boskonovitch', 'Mishima Corporation, Japan', 'Tokyo', '09991823467', 1, NULL, '2015-08-10 15:44:37.132', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (9, 'Feng', '', 'Wei', 'MALE', 'FF-WW-99', '1900-08-10', '', '', '', 'Shaolin Temple, Japan', 'Tokyo', '09991029572', 1, NULL, '2015-08-10 15:46:56.964', NULL);


--
-- TOC entry 2002 (class 0 OID 49382)
-- Dependencies: 174
-- Data for Name: patient_hiv_risk; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (3, 1);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (3, 2);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (3, 11);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (7, 2);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (7, 4);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (7, 6);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (7, 8);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (7, 10);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (7, 11);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (7, 13);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (8, 1);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (8, 3);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (8, 11);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (8, 13);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (9, 1);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (9, 2);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (9, 3);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (9, 4);


--
-- TOC entry 2025 (class 0 OID 0)
-- Dependencies: 175
-- Name: patient_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('patient_id_seq', 9, true);


--
-- TOC entry 2004 (class 0 OID 49387)
-- Dependencies: 176
-- Data for Name: role; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO role (id, code, name) VALUES (1, 'ROLE_ADMIN', 'Administrator');
INSERT INTO role (id, code, name) VALUES (2, 'ROLE_USER', 'User');


--
-- TOC entry 2026 (class 0 OID 0)
-- Dependencies: 177
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('role_id_seq', 2, true);


--
-- TOC entry 2006 (class 0 OID 49392)
-- Dependencies: 178
-- Data for Name: user; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO "user" (id, first_name, middle_name, last_name, email, password, username) VALUES (1, 'Gregory', NULL, 'House', 'gregory.house@hrms.com', '$2a$10$FAg/ZKl6/l/EKr9sq6eGfuUjJI.ZkkAJXMpoux8JBLgoPw4D7i5su', 'admin');


--
-- TOC entry 2027 (class 0 OID 0)
-- Dependencies: 179
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('user_id_seq', 1, true);


--
-- TOC entry 2008 (class 0 OID 49400)
-- Dependencies: 180
-- Data for Name: user_role; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);


--
-- TOC entry 2009 (class 0 OID 49403)
-- Dependencies: 181
-- Data for Name: vct; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO vct (id, patient_id, vct_date, is_hiv_tested, is_hiv_positive, reason_for_not_testing, provided_counseling_and_result, created_by, updated_by, created_date, updated_date) VALUES (1, 3, '2017-11-28', 0, 1, 'Because I am afraid', 1, 1, NULL, '2015-08-05 01:46:34.842', NULL);
INSERT INTO vct (id, patient_id, vct_date, is_hiv_tested, is_hiv_positive, reason_for_not_testing, provided_counseling_and_result, created_by, updated_by, created_date, updated_date) VALUES (2, 7, '2015-08-08', 1, 0, '', 0, 1, NULL, '2015-08-10 15:31:46.099', NULL);
INSERT INTO vct (id, patient_id, vct_date, is_hiv_tested, is_hiv_positive, reason_for_not_testing, provided_counseling_and_result, created_by, updated_by, created_date, updated_date) VALUES (3, 8, '2015-08-01', 0, 1, 'I''m awesome', 0, 1, NULL, '2015-08-10 15:44:37.132', NULL);
INSERT INTO vct (id, patient_id, vct_date, is_hiv_tested, is_hiv_positive, reason_for_not_testing, provided_counseling_and_result, created_by, updated_by, created_date, updated_date) VALUES (4, 9, '2015-08-08', 1, 1, '', 1, 1, NULL, '2015-08-10 15:46:56.964', NULL);


--
-- TOC entry 2028 (class 0 OID 0)
-- Dependencies: 182
-- Name: vct_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('vct_id_seq', 4, true);


--
-- TOC entry 1864 (class 2606 OID 49414)
-- Name: hiv_risk_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY hiv_risk
    ADD CONSTRAINT hiv_risk_id_pkey PRIMARY KEY (id);


--
-- TOC entry 1868 (class 2606 OID 49416)
-- Name: patient_hiv_risk_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY patient_hiv_risk
    ADD CONSTRAINT patient_hiv_risk_pkey PRIMARY KEY (patient_id, hiv_risk_id);


--
-- TOC entry 1866 (class 2606 OID 49418)
-- Name: patient_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY patient
    ADD CONSTRAINT patient_id_pkey PRIMARY KEY (id);


--
-- TOC entry 1870 (class 2606 OID 49420)
-- Name: role_code_key; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY role
    ADD CONSTRAINT role_code_key UNIQUE (code);


--
-- TOC entry 1872 (class 2606 OID 49422)
-- Name: role_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY role
    ADD CONSTRAINT role_id_pkey PRIMARY KEY (id);


--
-- TOC entry 1874 (class 2606 OID 49424)
-- Name: user_email_key; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_email_key UNIQUE (email);


--
-- TOC entry 1876 (class 2606 OID 49426)
-- Name: user_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_id_pkey PRIMARY KEY (id);


--
-- TOC entry 1880 (class 2606 OID 49428)
-- Name: user_role_ids_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_ids_pkey PRIMARY KEY (user_id, role_id);


--
-- TOC entry 1878 (class 2606 OID 49430)
-- Name: user_username_key; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_username_key UNIQUE (username);


--
-- TOC entry 1882 (class 2606 OID 49432)
-- Name: vct_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY vct
    ADD CONSTRAINT vct_id_pkey PRIMARY KEY (id);


--
-- TOC entry 1883 (class 2606 OID 49433)
-- Name: patient_created_by_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY patient
    ADD CONSTRAINT patient_created_by_fkey FOREIGN KEY (created_by) REFERENCES "user"(id);


--
-- TOC entry 1885 (class 2606 OID 49438)
-- Name: patient_hiv_risk_hiv_risk_id_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY patient_hiv_risk
    ADD CONSTRAINT patient_hiv_risk_hiv_risk_id_fkey FOREIGN KEY (hiv_risk_id) REFERENCES hiv_risk(id);


--
-- TOC entry 1886 (class 2606 OID 49443)
-- Name: patient_hiv_risk_patient_id_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY patient_hiv_risk
    ADD CONSTRAINT patient_hiv_risk_patient_id_fkey FOREIGN KEY (patient_id) REFERENCES patient(id);


--
-- TOC entry 1884 (class 2606 OID 49448)
-- Name: patient_updated_by_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY patient
    ADD CONSTRAINT patient_updated_by_fkey FOREIGN KEY (updated_by) REFERENCES "user"(id);


--
-- TOC entry 1887 (class 2606 OID 49453)
-- Name: user_role_role_id_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_role_id_fkey FOREIGN KEY (role_id) REFERENCES role(id);


--
-- TOC entry 1888 (class 2606 OID 49458)
-- Name: user_role_user_id_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_user_id_fkey FOREIGN KEY (user_id) REFERENCES "user"(id);


--
-- TOC entry 1889 (class 2606 OID 49463)
-- Name: vct_created_by_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY vct
    ADD CONSTRAINT vct_created_by_fkey FOREIGN KEY (created_by) REFERENCES "user"(id);


--
-- TOC entry 1890 (class 2606 OID 49468)
-- Name: vct_patient_id_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY vct
    ADD CONSTRAINT vct_patient_id_fkey FOREIGN KEY (patient_id) REFERENCES patient(id);


--
-- TOC entry 1891 (class 2606 OID 49473)
-- Name: vct_updated_by_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY vct
    ADD CONSTRAINT vct_updated_by_fkey FOREIGN KEY (updated_by) REFERENCES "user"(id);


--
-- TOC entry 2017 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-08-10 15:49:45

--
-- PostgreSQL database dump complete
--

