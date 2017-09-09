-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-09-2017 a las 00:02:58
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `medicaldb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `id_cita` int(11) NOT NULL,
  `id_paciente` int(11) DEFAULT NULL,
  `id_medico` int(11) DEFAULT NULL,
  `id_diagnostico` int(11) DEFAULT NULL,
  `id_procedimiento` int(11) DEFAULT NULL,
  `fecha_cita` date DEFAULT NULL,
  `hora_cita` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `diagnostico`
--

CREATE TABLE `diagnostico` (
  `id_diagnostico` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `id_especialidad` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`id_especialidad`, `descripcion`) VALUES
(1, 'CARDIOLOGO'),
(2, 'NEUROLOGO'),
(3, 'DERMATOLOGO'),
(4, 'UROLOGO'),
(5, 'GINECOLOGO'),
(6, 'ORTOPEDA'),
(7, 'OFTARMOLOGO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `id_medico` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `cedula` varchar(20) DEFAULT NULL,
  `fechanac` varchar(20) DEFAULT NULL,
  `id_especialidad` int(11) DEFAULT NULL,
  `genero` char(1) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `medico`
--

INSERT INTO `medico` (`id_medico`, `nombre`, `apellido`, `cedula`, `fechanac`, `id_especialidad`, `genero`, `telefono`, `direccion`, `correo`) VALUES
(1, 'Alex', 'Abreu', '', '', 0, '', '', '', 'aabreu@gmail.com'),
(2, 'Pedro', 'Rios', '', '', 0, '', '', '', 'prios@gmail.com'),
(3, 'Jose', 'Cabrera', '', '', 0, '', '', '', 'jcabrera@gmail.com'),
(4, 'Pedro', 'Aguilar', '', '', 0, '', '', '', 'paguilar@gmail.com'),
(5, 'Marcos', 'Reyes', '', '', 0, '', '', '', 'mreyes@gmail.com'),
(6, 'Jose', 'Mezquita', '', '', 0, '', '', '', 'jmezquita@gmail.com'),
(8, 'Jose', 'Arias', '', '', 0, '', '', '', 'jarias@gmail.com'),
(9, 'Oscar', 'Rios', '', '', 0, '', '', '', 'orios@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `id_paciente` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `cedula` varchar(20) DEFAULT NULL,
  `fechanac` int(11) DEFAULT NULL,
  `genero` char(1) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`id_paciente`, `nombre`, `apellido`, `cedula`, `fechanac`, `genero`, `telefono`, `direccion`, `correo`) VALUES
(1, 'Jose', 'Reyes', '23223123', NULL, NULL, '53212345', 'La Vega', 'jose.rey@gmail.com'),
(2, 'Celenia', 'Reynoso', '2212312235', NULL, NULL, '822665322', 'Santiago', 'celereynoso@gmail.com'),
(3, 'Omar', 'Rios', '2232315665', NULL, NULL, '8556542322', 'Higuey', 'omarrios@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `procedimiento`
--

CREATE TABLE `procedimiento` (
  `id_procedimiento` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `procedimiento`
--

INSERT INTO `procedimiento` (`id_procedimiento`, `descripcion`) VALUES
(1, 'Apendicectomía'),
(2, 'Biopsia de mama'),
(3, 'Endoarteriectomía de la carótida'),
(4, 'Cirugía de cataratas'),
(5, 'Cesárea'),
(6, 'Colecistectomía'),
(7, 'Bypass de arteria coronaria'),
(8, 'Desbridamiento de heridas'),
(9, 'Injerto libre de piel'),
(10, 'Histeroscopia');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`id_cita`);

--
-- Indices de la tabla `diagnostico`
--
ALTER TABLE `diagnostico`
  ADD PRIMARY KEY (`id_diagnostico`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`id_especialidad`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id_medico`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id_paciente`);

--
-- Indices de la tabla `procedimiento`
--
ALTER TABLE `procedimiento`
  ADD PRIMARY KEY (`id_procedimiento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cita`
--
ALTER TABLE `cita`
  MODIFY `id_cita` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `diagnostico`
--
ALTER TABLE `diagnostico`
  MODIFY `id_diagnostico` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  MODIFY `id_especialidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `medico`
--
ALTER TABLE `medico`
  MODIFY `id_medico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `id_paciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `procedimiento`
--
ALTER TABLE `procedimiento`
  MODIFY `id_procedimiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
