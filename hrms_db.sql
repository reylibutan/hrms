--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.0
-- Started on 2015-08-03 23:08:56

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 7 (class 2615 OID 16456)
-- Name: hrms; Type: SCHEMA; Schema: -; Owner: hrms_user
--

CREATE SCHEMA hrms;


ALTER SCHEMA hrms OWNER TO hrms_user;

--
-- TOC entry 182 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2055 (class 0 OID 0)
-- Dependencies: 182
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = hrms, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 179 (class 1259 OID 16499)
-- Name: hiv_risk; Type: TABLE; Schema: hrms; Owner: hrms_user; Tablespace: 
--

CREATE TABLE hiv_risk (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    parent_id bigint,
    has_children boolean
);


ALTER TABLE hiv_risk OWNER TO hrms_user;

--
-- TOC entry 178 (class 1259 OID 16497)
-- Name: hiv_risk_id_seq; Type: SEQUENCE; Schema: hrms; Owner: hrms_user
--

CREATE SEQUENCE hiv_risk_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hiv_risk_id_seq OWNER TO hrms_user;

--
-- TOC entry 2056 (class 0 OID 0)
-- Dependencies: 178
-- Name: hiv_risk_id_seq; Type: SEQUENCE OWNED BY; Schema: hrms; Owner: hrms_user
--

ALTER SEQUENCE hiv_risk_id_seq OWNED BY hiv_risk.id;


--
-- TOC entry 181 (class 1259 OID 24691)
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


ALTER TABLE patient OWNER TO hrms_user;

--
-- TOC entry 180 (class 1259 OID 24689)
-- Name: patient_id_seq; Type: SEQUENCE; Schema: hrms; Owner: hrms_user
--

CREATE SEQUENCE patient_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE patient_id_seq OWNER TO hrms_user;

--
-- TOC entry 2057 (class 0 OID 0)
-- Dependencies: 180
-- Name: patient_id_seq; Type: SEQUENCE OWNED BY; Schema: hrms; Owner: hrms_user
--

ALTER SEQUENCE patient_id_seq OWNED BY patient.id;


--
-- TOC entry 176 (class 1259 OID 16472)
-- Name: role; Type: TABLE; Schema: hrms; Owner: hrms_user; Tablespace: 
--

CREATE TABLE role (
    id bigint NOT NULL,
    code character varying(55) NOT NULL,
    name character varying(255)
);


ALTER TABLE role OWNER TO hrms_user;

--
-- TOC entry 175 (class 1259 OID 16470)
-- Name: role_id_seq; Type: SEQUENCE; Schema: hrms; Owner: hrms_user
--

CREATE SEQUENCE role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE role_id_seq OWNER TO hrms_user;

--
-- TOC entry 2058 (class 0 OID 0)
-- Dependencies: 175
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: hrms; Owner: hrms_user
--

ALTER SEQUENCE role_id_seq OWNED BY role.id;


--
-- TOC entry 174 (class 1259 OID 16459)
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


ALTER TABLE "user" OWNER TO hrms_user;

--
-- TOC entry 173 (class 1259 OID 16457)
-- Name: user_id_seq; Type: SEQUENCE; Schema: hrms; Owner: hrms_user
--

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_id_seq OWNER TO hrms_user;

--
-- TOC entry 2059 (class 0 OID 0)
-- Dependencies: 173
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: hrms; Owner: hrms_user
--

ALTER SEQUENCE user_id_seq OWNED BY "user".id;


--
-- TOC entry 177 (class 1259 OID 16480)
-- Name: user_role; Type: TABLE; Schema: hrms; Owner: hrms_user; Tablespace: 
--

CREATE TABLE user_role (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE user_role OWNER TO hrms_user;

--
-- TOC entry 1908 (class 2604 OID 16502)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY hiv_risk ALTER COLUMN id SET DEFAULT nextval('hiv_risk_id_seq'::regclass);


--
-- TOC entry 1909 (class 2604 OID 24694)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY patient ALTER COLUMN id SET DEFAULT nextval('patient_id_seq'::regclass);


--
-- TOC entry 1907 (class 2604 OID 16475)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY role ALTER COLUMN id SET DEFAULT nextval('role_id_seq'::regclass);


--
-- TOC entry 1906 (class 2604 OID 16462)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


--
-- TOC entry 2045 (class 0 OID 16499)
-- Dependencies: 179
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
-- TOC entry 2060 (class 0 OID 0)
-- Dependencies: 178
-- Name: hiv_risk_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('hiv_risk_id_seq', 13, true);


--
-- TOC entry 2047 (class 0 OID 24691)
-- Dependencies: 181
-- Data for Name: patient; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (3, 'Rey', 'Patigas', 'Libutan', 'MALE', 'XX-YY-99', '1992-06-27', 'Belle', 'Cerna', 'Patigas', 'Deca Homes Baywalk, Brgy. Dumlog', 'Talisay City', '09432935645', 1, NULL, '2015-08-03 23:06:52.275', NULL);


--
-- TOC entry 2061 (class 0 OID 0)
-- Dependencies: 180
-- Name: patient_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('patient_id_seq', 3, true);


--
-- TOC entry 2042 (class 0 OID 16472)
-- Dependencies: 176
-- Data for Name: role; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO role (id, code, name) VALUES (1, 'ROLE_ADMIN', 'Administrator');
INSERT INTO role (id, code, name) VALUES (2, 'ROLE_USER', 'User');


--
-- TOC entry 2062 (class 0 OID 0)
-- Dependencies: 175
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('role_id_seq', 2, true);


--
-- TOC entry 2040 (class 0 OID 16459)
-- Dependencies: 174
-- Data for Name: user; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO "user" (id, first_name, middle_name, last_name, email, password, username) VALUES (1, 'Gregory', NULL, 'House', 'gregory.house@hrms.com', '$2a$10$FAg/ZKl6/l/EKr9sq6eGfuUjJI.ZkkAJXMpoux8JBLgoPw4D7i5su', 'admin');


--
-- TOC entry 2063 (class 0 OID 0)
-- Dependencies: 173
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('user_id_seq', 1, true);


--
-- TOC entry 2043 (class 0 OID 16480)
-- Dependencies: 177
-- Data for Name: user_role; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);


--
-- TOC entry 1923 (class 2606 OID 16504)
-- Name: hiv_risk_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY hiv_risk
    ADD CONSTRAINT hiv_risk_id_pkey PRIMARY KEY (id);


--
-- TOC entry 1925 (class 2606 OID 24699)
-- Name: patient_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY patient
    ADD CONSTRAINT patient_id_pkey PRIMARY KEY (id);


--
-- TOC entry 1917 (class 2606 OID 16479)
-- Name: role_code_key; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY role
    ADD CONSTRAINT role_code_key UNIQUE (code);


--
-- TOC entry 1919 (class 2606 OID 16477)
-- Name: role_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY role
    ADD CONSTRAINT role_id_pkey PRIMARY KEY (id);


--
-- TOC entry 1911 (class 2606 OID 16469)
-- Name: user_email_key; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_email_key UNIQUE (email);


--
-- TOC entry 1913 (class 2606 OID 16467)
-- Name: user_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_id_pkey PRIMARY KEY (id);


--
-- TOC entry 1921 (class 2606 OID 16484)
-- Name: user_role_ids_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_ids_pkey PRIMARY KEY (user_id, role_id);


--
-- TOC entry 1915 (class 2606 OID 16496)
-- Name: user_username_key; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_username_key UNIQUE (username);


--
-- TOC entry 1928 (class 2606 OID 24700)
-- Name: patient_created_by_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY patient
    ADD CONSTRAINT patient_created_by_fkey FOREIGN KEY (created_by) REFERENCES "user"(id);


--
-- TOC entry 1929 (class 2606 OID 24705)
-- Name: patient_updated_by_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY patient
    ADD CONSTRAINT patient_updated_by_fkey FOREIGN KEY (updated_by) REFERENCES "user"(id);


--
-- TOC entry 1927 (class 2606 OID 16490)
-- Name: user_role_role_id_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_role_id_fkey FOREIGN KEY (role_id) REFERENCES role(id);


--
-- TOC entry 1926 (class 2606 OID 16485)
-- Name: user_role_user_id_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_user_id_fkey FOREIGN KEY (user_id) REFERENCES "user"(id);


--
-- TOC entry 2054 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-08-03 23:08:57

--
-- PostgreSQL database dump complete
--

