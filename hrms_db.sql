--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.18
-- Dumped by pg_dump version 9.4.0
-- Started on 2015-08-15 21:10:14

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 6 (class 2615 OID 102344390)
-- Name: hrms; Type: SCHEMA; Schema: -; Owner: hrms_user
--

CREATE SCHEMA hrms;


ALTER SCHEMA hrms OWNER TO hrms_user;

SET search_path = hrms, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 162 (class 1259 OID 102344391)
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
-- TOC entry 163 (class 1259 OID 102344394)
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
-- TOC entry 2799 (class 0 OID 0)
-- Dependencies: 163
-- Name: hiv_risk_id_seq; Type: SEQUENCE OWNED BY; Schema: hrms; Owner: hrms_user
--

ALTER SEQUENCE hiv_risk_id_seq OWNED BY hiv_risk.id;


--
-- TOC entry 164 (class 1259 OID 102344396)
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
-- TOC entry 165 (class 1259 OID 102344402)
-- Name: patient_hiv_risk; Type: TABLE; Schema: hrms; Owner: hrms_user; Tablespace: 
--

CREATE TABLE patient_hiv_risk (
    patient_id bigint NOT NULL,
    hiv_risk_id bigint NOT NULL
);


ALTER TABLE patient_hiv_risk OWNER TO hrms_user;

--
-- TOC entry 166 (class 1259 OID 102344405)
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
-- TOC entry 2800 (class 0 OID 0)
-- Dependencies: 166
-- Name: patient_id_seq; Type: SEQUENCE OWNED BY; Schema: hrms; Owner: hrms_user
--

ALTER SEQUENCE patient_id_seq OWNED BY patient.id;


--
-- TOC entry 167 (class 1259 OID 102344407)
-- Name: role; Type: TABLE; Schema: hrms; Owner: hrms_user; Tablespace: 
--

CREATE TABLE role (
    id bigint NOT NULL,
    code character varying(55) NOT NULL,
    name character varying(255)
);


ALTER TABLE role OWNER TO hrms_user;

--
-- TOC entry 168 (class 1259 OID 102344410)
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
-- TOC entry 2801 (class 0 OID 0)
-- Dependencies: 168
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: hrms; Owner: hrms_user
--

ALTER SEQUENCE role_id_seq OWNED BY role.id;


--
-- TOC entry 169 (class 1259 OID 102344412)
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
-- TOC entry 170 (class 1259 OID 102344418)
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
-- TOC entry 2802 (class 0 OID 0)
-- Dependencies: 170
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: hrms; Owner: hrms_user
--

ALTER SEQUENCE user_id_seq OWNED BY "user".id;


--
-- TOC entry 171 (class 1259 OID 102344420)
-- Name: user_role; Type: TABLE; Schema: hrms; Owner: hrms_user; Tablespace: 
--

CREATE TABLE user_role (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE user_role OWNER TO hrms_user;

--
-- TOC entry 172 (class 1259 OID 102344423)
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


ALTER TABLE vct OWNER TO hrms_user;

--
-- TOC entry 173 (class 1259 OID 102344426)
-- Name: vct_id_seq; Type: SEQUENCE; Schema: hrms; Owner: hrms_user
--

CREATE SEQUENCE vct_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE vct_id_seq OWNER TO hrms_user;

--
-- TOC entry 2803 (class 0 OID 0)
-- Dependencies: 173
-- Name: vct_id_seq; Type: SEQUENCE OWNED BY; Schema: hrms; Owner: hrms_user
--

ALTER SEQUENCE vct_id_seq OWNED BY vct.id;


--
-- TOC entry 2648 (class 2604 OID 102344428)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY hiv_risk ALTER COLUMN id SET DEFAULT nextval('hiv_risk_id_seq'::regclass);


--
-- TOC entry 2649 (class 2604 OID 102344429)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY patient ALTER COLUMN id SET DEFAULT nextval('patient_id_seq'::regclass);


--
-- TOC entry 2650 (class 2604 OID 102344430)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY role ALTER COLUMN id SET DEFAULT nextval('role_id_seq'::regclass);


--
-- TOC entry 2651 (class 2604 OID 102344431)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


--
-- TOC entry 2652 (class 2604 OID 102344432)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY vct ALTER COLUMN id SET DEFAULT nextval('vct_id_seq'::regclass);


--
-- TOC entry 2783 (class 0 OID 102344391)
-- Dependencies: 162
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
-- TOC entry 2804 (class 0 OID 0)
-- Dependencies: 163
-- Name: hiv_risk_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('hiv_risk_id_seq', 13, true);


--
-- TOC entry 2785 (class 0 OID 102344396)
-- Dependencies: 164
-- Data for Name: patient; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (4, 'Rey', 'Patigas', 'Libutan', 'MALE', 'XX-YY-99', '2015-08-26', '', '', '', '', '', '', 1, NULL, '2015-08-04 23:57:35.171', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (5, 'Rey', 'Patigas', 'Libutan', 'MALE', 'XX-YY-99', '1992-06-27', '', '', '', '', '', '', 1, NULL, '2015-08-04 23:59:30.411', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (7, 'Jin', '', 'Kazama', 'MALE', 'JJ-KK-99', '1982-08-10', 'Jun', '', 'Kazama', 'Mishima Corporation, Japan', 'Tokyo', '09992748562', 1, NULL, '2015-08-10 15:31:46.099', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (3, 'Rey', 'Patigas', 'Libutan', 'MALE', 'XX-YY-99', '1992-06-27', 'Belle', 'Cerna', 'Patigas', 'Deca Homes Baywalk, Brgy. Dumlog', 'Talisay City', '09432935645', 1, NULL, '2015-08-13 08:12:54.511', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (11, 'Craig', '', 'Marduk', 'MALE', 'CC-MM-22', '1979-08-14', '', '', '', 'Mishima Corporation, Japan', 'Tokyo', '091029356', 1, NULL, '2015-08-14 15:06:39.06', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (8, 'Lee', '', 'Chaolan', 'MALE', 'LL-CC-99', '1989-08-11', 'Alisa', '', 'Boskonovitch', 'Mishima Corporation, Japan', 'Tokyo', '09991823467', 1, NULL, '2015-08-14 15:30:18.884', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (9, 'Feng', '', 'Wei', 'MALE', 'FF-WW-99', '1982-04-02', '', '', '', 'Shaolin Temple, Japan', 'Tokyo', '09991029572', 1, NULL, '2015-08-14 15:30:55.356', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (10, 'Wang', '', 'Jinrei', 'MALE', 'WW-JJ-23', '1980-04-04', '', '', '', 'Mishima Corporation, Japan', 'Tokyo', '09998924062', 1, NULL, '2015-08-14 15:32:08.31', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (12, 'Kuma', '', 'Panda', 'MALE', 'KK-MM-01', '1999-08-14', '', '', '', '', '', '', 1, NULL, '2015-08-14 16:37:01.395', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (13, 'Eleonore', '', 'Kliesen', 'FEMALE', 'EE-KK-09', '1992-08-14', '', '', '', 'Mishima Corporation, Japan', 'Tokyo', '', 1, NULL, '2015-08-14 16:38:05.398', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (15, 'Eddie', '', 'Gordo', 'MALE', 'EE-GG-00', '1990-08-14', '', '', '', '', '', '', 1, NULL, '2015-08-14 16:44:10.827', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (16, 'Christie', '', 'Monteiro', 'FEMALE', 'CC-MM-21', '1991-08-14', '', '', '', '', '', '', 1, NULL, '2015-08-14 16:44:33.349', NULL);
INSERT INTO patient (id, first_name, middle_name, last_name, sex, unique_id_code, birthdate, mom_first_name, mom_middle_name, mom_last_name, address, city, contact_number, created_by, updated_by, created_date, updated_date) VALUES (14, 'Alisa', '', 'Boskonovitch', 'FEMALE', 'AA-BB-90', '2014-08-14', '', '', '', '', '', '', 1, NULL, '2015-08-14 16:45:11.788', NULL);


--
-- TOC entry 2786 (class 0 OID 102344402)
-- Dependencies: 165
-- Data for Name: patient_hiv_risk; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (7, 2);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (7, 4);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (7, 6);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (7, 8);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (7, 10);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (7, 11);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (7, 13);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (3, 1);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (3, 2);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (3, 3);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (3, 4);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (3, 5);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (3, 6);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (3, 7);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (3, 8);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (3, 9);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (3, 10);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (3, 11);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (3, 12);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (11, 1);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (8, 1);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (8, 3);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (8, 11);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (8, 13);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (9, 1);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (9, 2);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (9, 3);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (9, 4);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (10, 2);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (10, 4);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (10, 6);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (10, 8);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (12, 5);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (12, 6);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (12, 7);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (12, 8);
INSERT INTO patient_hiv_risk (patient_id, hiv_risk_id) VALUES (13, 5);


--
-- TOC entry 2805 (class 0 OID 0)
-- Dependencies: 166
-- Name: patient_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('patient_id_seq', 16, true);


--
-- TOC entry 2788 (class 0 OID 102344407)
-- Dependencies: 167
-- Data for Name: role; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO role (id, code, name) VALUES (1, 'ROLE_ADMIN', 'Administrator');
INSERT INTO role (id, code, name) VALUES (2, 'ROLE_USER', 'User');


--
-- TOC entry 2806 (class 0 OID 0)
-- Dependencies: 168
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('role_id_seq', 2, true);


--
-- TOC entry 2790 (class 0 OID 102344412)
-- Dependencies: 169
-- Data for Name: user; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO "user" (id, first_name, middle_name, last_name, email, password, username) VALUES (1, 'Gregory', NULL, 'House', 'gregory.house@hrms.com', '$2a$10$FAg/ZKl6/l/EKr9sq6eGfuUjJI.ZkkAJXMpoux8JBLgoPw4D7i5su', 'admin');


--
-- TOC entry 2807 (class 0 OID 0)
-- Dependencies: 170
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('user_id_seq', 1, true);


--
-- TOC entry 2792 (class 0 OID 102344420)
-- Dependencies: 171
-- Data for Name: user_role; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);


--
-- TOC entry 2793 (class 0 OID 102344423)
-- Dependencies: 172
-- Data for Name: vct; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO vct (id, patient_id, vct_date, is_hiv_tested, is_hiv_positive, reason_for_not_testing, provided_counseling_and_result, created_by, updated_by, created_date, updated_date) VALUES (2, 7, '2015-08-08', 1, 0, '', 0, 1, NULL, '2015-08-10 15:31:46.099', NULL);
INSERT INTO vct (id, patient_id, vct_date, is_hiv_tested, is_hiv_positive, reason_for_not_testing, provided_counseling_and_result, created_by, updated_by, created_date, updated_date) VALUES (1, 3, '2017-12-04', 1, 1, 'Because I am afraid', 1, 1, NULL, '2015-08-13 08:12:54.511', NULL);
INSERT INTO vct (id, patient_id, vct_date, is_hiv_tested, is_hiv_positive, reason_for_not_testing, provided_counseling_and_result, created_by, updated_by, created_date, updated_date) VALUES (6, 11, '2015-08-01', 1, 1, '', 1, 1, NULL, '2015-08-14 15:06:39.06', NULL);
INSERT INTO vct (id, patient_id, vct_date, is_hiv_tested, is_hiv_positive, reason_for_not_testing, provided_counseling_and_result, created_by, updated_by, created_date, updated_date) VALUES (3, 8, '2015-08-01', 0, 1, 'I''m awesome', 0, 1, NULL, '2015-08-14 15:30:18.884', NULL);
INSERT INTO vct (id, patient_id, vct_date, is_hiv_tested, is_hiv_positive, reason_for_not_testing, provided_counseling_and_result, created_by, updated_by, created_date, updated_date) VALUES (4, 9, '2015-08-08', 1, 1, '', 1, 1, NULL, '2015-08-14 15:30:55.356', NULL);
INSERT INTO vct (id, patient_id, vct_date, is_hiv_tested, is_hiv_positive, reason_for_not_testing, provided_counseling_and_result, created_by, updated_by, created_date, updated_date) VALUES (5, 10, '2016-05-06', 1, 1, '', 1, 1, NULL, '2015-08-14 15:32:08.31', NULL);
INSERT INTO vct (id, patient_id, vct_date, is_hiv_tested, is_hiv_positive, reason_for_not_testing, provided_counseling_and_result, created_by, updated_by, created_date, updated_date) VALUES (7, 12, '2015-08-08', 1, 1, '', 1, 1, NULL, '2015-08-14 16:37:01.395', NULL);
INSERT INTO vct (id, patient_id, vct_date, is_hiv_tested, is_hiv_positive, reason_for_not_testing, provided_counseling_and_result, created_by, updated_by, created_date, updated_date) VALUES (8, 13, '2015-08-01', 1, 1, '', 1, 1, NULL, '2015-08-14 16:38:05.398', NULL);
INSERT INTO vct (id, patient_id, vct_date, is_hiv_tested, is_hiv_positive, reason_for_not_testing, provided_counseling_and_result, created_by, updated_by, created_date, updated_date) VALUES (10, 15, '2015-08-04', 1, 1, '', 1, 1, NULL, '2015-08-14 16:44:10.827', NULL);
INSERT INTO vct (id, patient_id, vct_date, is_hiv_tested, is_hiv_positive, reason_for_not_testing, provided_counseling_and_result, created_by, updated_by, created_date, updated_date) VALUES (11, 16, '2015-07-30', 1, 1, '', 1, 1, NULL, '2015-08-14 16:44:33.349', NULL);
INSERT INTO vct (id, patient_id, vct_date, is_hiv_tested, is_hiv_positive, reason_for_not_testing, provided_counseling_and_result, created_by, updated_by, created_date, updated_date) VALUES (9, 14, '2015-08-08', 1, 1, '', 1, 1, NULL, '2015-08-14 16:45:11.788', NULL);


--
-- TOC entry 2808 (class 0 OID 0)
-- Dependencies: 173
-- Name: vct_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('vct_id_seq', 11, true);


--
-- TOC entry 2654 (class 2606 OID 102344434)
-- Name: hiv_risk_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY hiv_risk
    ADD CONSTRAINT hiv_risk_id_pkey PRIMARY KEY (id);


--
-- TOC entry 2658 (class 2606 OID 102344436)
-- Name: patient_hiv_risk_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY patient_hiv_risk
    ADD CONSTRAINT patient_hiv_risk_pkey PRIMARY KEY (patient_id, hiv_risk_id);


--
-- TOC entry 2656 (class 2606 OID 102344438)
-- Name: patient_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY patient
    ADD CONSTRAINT patient_id_pkey PRIMARY KEY (id);


--
-- TOC entry 2660 (class 2606 OID 102344440)
-- Name: role_code_key; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY role
    ADD CONSTRAINT role_code_key UNIQUE (code);


--
-- TOC entry 2662 (class 2606 OID 102344442)
-- Name: role_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY role
    ADD CONSTRAINT role_id_pkey PRIMARY KEY (id);


--
-- TOC entry 2664 (class 2606 OID 102344444)
-- Name: user_email_key; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_email_key UNIQUE (email);


--
-- TOC entry 2666 (class 2606 OID 102344446)
-- Name: user_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_id_pkey PRIMARY KEY (id);


--
-- TOC entry 2670 (class 2606 OID 102344448)
-- Name: user_role_ids_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_ids_pkey PRIMARY KEY (user_id, role_id);


--
-- TOC entry 2668 (class 2606 OID 102344450)
-- Name: user_username_key; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_username_key UNIQUE (username);


--
-- TOC entry 2672 (class 2606 OID 102344452)
-- Name: vct_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY vct
    ADD CONSTRAINT vct_id_pkey PRIMARY KEY (id);


--
-- TOC entry 2673 (class 2606 OID 102344453)
-- Name: patient_created_by_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY patient
    ADD CONSTRAINT patient_created_by_fkey FOREIGN KEY (created_by) REFERENCES "user"(id);


--
-- TOC entry 2675 (class 2606 OID 102344458)
-- Name: patient_hiv_risk_hiv_risk_id_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY patient_hiv_risk
    ADD CONSTRAINT patient_hiv_risk_hiv_risk_id_fkey FOREIGN KEY (hiv_risk_id) REFERENCES hiv_risk(id);


--
-- TOC entry 2676 (class 2606 OID 102344463)
-- Name: patient_hiv_risk_patient_id_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY patient_hiv_risk
    ADD CONSTRAINT patient_hiv_risk_patient_id_fkey FOREIGN KEY (patient_id) REFERENCES patient(id);


--
-- TOC entry 2674 (class 2606 OID 102344468)
-- Name: patient_updated_by_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY patient
    ADD CONSTRAINT patient_updated_by_fkey FOREIGN KEY (updated_by) REFERENCES "user"(id);


--
-- TOC entry 2677 (class 2606 OID 102344473)
-- Name: user_role_role_id_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_role_id_fkey FOREIGN KEY (role_id) REFERENCES role(id);


--
-- TOC entry 2678 (class 2606 OID 102344478)
-- Name: user_role_user_id_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_user_id_fkey FOREIGN KEY (user_id) REFERENCES "user"(id);


--
-- TOC entry 2679 (class 2606 OID 102344483)
-- Name: vct_created_by_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY vct
    ADD CONSTRAINT vct_created_by_fkey FOREIGN KEY (created_by) REFERENCES "user"(id);


--
-- TOC entry 2680 (class 2606 OID 102344488)
-- Name: vct_patient_id_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY vct
    ADD CONSTRAINT vct_patient_id_fkey FOREIGN KEY (patient_id) REFERENCES patient(id);


--
-- TOC entry 2681 (class 2606 OID 102344493)
-- Name: vct_updated_by_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY vct
    ADD CONSTRAINT vct_updated_by_fkey FOREIGN KEY (updated_by) REFERENCES "user"(id);


-- Completed on 2015-08-15 21:11:08

--
-- PostgreSQL database dump complete
--

