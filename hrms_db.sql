--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.0
-- Started on 2015-07-22 03:41:36

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

SET search_path = hrms, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

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
-- TOC entry 2027 (class 0 OID 0)
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
-- TOC entry 2028 (class 0 OID 0)
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
-- TOC entry 1894 (class 2604 OID 16475)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY role ALTER COLUMN id SET DEFAULT nextval('role_id_seq'::regclass);


--
-- TOC entry 1893 (class 2604 OID 16462)
-- Name: id; Type: DEFAULT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


--
-- TOC entry 2021 (class 0 OID 16472)
-- Dependencies: 176
-- Data for Name: role; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO role (id, code, name) VALUES (1, 'ROLE_ADMIN', 'Administrator');
INSERT INTO role (id, code, name) VALUES (2, 'ROLE_USER', 'User');


--
-- TOC entry 2029 (class 0 OID 0)
-- Dependencies: 175
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('role_id_seq', 2, true);


--
-- TOC entry 2019 (class 0 OID 16459)
-- Dependencies: 174
-- Data for Name: user; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO "user" (id, first_name, middle_name, last_name, email, password, username) VALUES (1, 'Gregory', NULL, 'House', 'gregory.house@hrms.com', '$2a$10$FAg/ZKl6/l/EKr9sq6eGfuUjJI.ZkkAJXMpoux8JBLgoPw4D7i5su', 'admin');


--
-- TOC entry 2030 (class 0 OID 0)
-- Dependencies: 173
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: hrms; Owner: hrms_user
--

SELECT pg_catalog.setval('user_id_seq', 1, true);


--
-- TOC entry 2022 (class 0 OID 16480)
-- Dependencies: 177
-- Data for Name: user_role; Type: TABLE DATA; Schema: hrms; Owner: hrms_user
--

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);


--
-- TOC entry 1902 (class 2606 OID 16479)
-- Name: role_code_key; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY role
    ADD CONSTRAINT role_code_key UNIQUE (code);


--
-- TOC entry 1904 (class 2606 OID 16477)
-- Name: role_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY role
    ADD CONSTRAINT role_id_pkey PRIMARY KEY (id);


--
-- TOC entry 1896 (class 2606 OID 16469)
-- Name: user_email_key; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_email_key UNIQUE (email);


--
-- TOC entry 1898 (class 2606 OID 16467)
-- Name: user_id_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_id_pkey PRIMARY KEY (id);


--
-- TOC entry 1906 (class 2606 OID 16484)
-- Name: user_role_ids_pkey; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_ids_pkey PRIMARY KEY (user_id, role_id);


--
-- TOC entry 1900 (class 2606 OID 16496)
-- Name: user_username_key; Type: CONSTRAINT; Schema: hrms; Owner: hrms_user; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_username_key UNIQUE (username);


--
-- TOC entry 1908 (class 2606 OID 16490)
-- Name: user_role_role_id_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_role_id_fkey FOREIGN KEY (role_id) REFERENCES role(id);


--
-- TOC entry 1907 (class 2606 OID 16485)
-- Name: user_role_user_id_fkey; Type: FK CONSTRAINT; Schema: hrms; Owner: hrms_user
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_user_id_fkey FOREIGN KEY (user_id) REFERENCES "user"(id);


-- Completed on 2015-07-22 03:41:36

--
-- PostgreSQL database dump complete
--

