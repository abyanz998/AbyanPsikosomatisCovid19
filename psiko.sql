-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 05 Bulan Mei 2020 pada 05.59
-- Versi server: 10.3.16-MariaDB
-- Versi PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `psiko`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `hasil_tes`
--

CREATE TABLE `hasil_tes` (
  `id_hasil` int(11) NOT NULL,
  `id_tes` int(11) NOT NULL,
  `skor_tes` varchar(255) NOT NULL,
  `penanganan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `hasil_tes`
--

INSERT INTO `hasil_tes` (`id_hasil`, `id_tes`, `skor_tes`, `penanganan`) VALUES
(1, 1, '200', 'berat');

-- --------------------------------------------------------

--
-- Struktur dari tabel `info_psikosomatis`
--

CREATE TABLE `info_psikosomatis` (
  `id_konten` int(11) NOT NULL,
  `konten` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `penanganan_ringan`
--

CREATE TABLE `penanganan_ringan` (
  `id_penanganan_ringan` int(11) NOT NULL,
  `id_hasil_tes` int(11) NOT NULL,
  `saran_pencegahan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `penanganan_sedang`
--

CREATE TABLE `penanganan_sedang` (
  `id_penanganan_sedang` int(11) NOT NULL,
  `id_hasil_tes` int(11) NOT NULL,
  `saran_pengobatan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tenaga_medis`
--

CREATE TABLE `tenaga_medis` (
  `id_medis` int(11) NOT NULL,
  `id_hasil_tes` int(11) NOT NULL,
  `nama_psikolog` varchar(255) NOT NULL,
  `alamat_psikolog` varchar(255) NOT NULL,
  `nomor_telepon` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tes`
--

CREATE TABLE `tes` (
  `id_tes` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `pertanyaan_1` varchar(20) NOT NULL,
  `pertanyaan_2` varchar(20) NOT NULL,
  `pertanyaan_3` varchar(20) NOT NULL,
  `pertanyaan_4` varchar(20) NOT NULL,
  `pertanyaan_5` varchar(20) NOT NULL,
  `pertanyaan_6` varchar(20) NOT NULL,
  `pertanyaan_7` varchar(20) NOT NULL,
  `pertanyaan_8` varchar(20) NOT NULL,
  `pertanyaan_9` varchar(20) NOT NULL,
  `pertanyaan_10` varchar(20) NOT NULL,
  `pertanyaan_11` varchar(20) NOT NULL,
  `pertanyaan_12` varchar(20) NOT NULL,
  `pertanyaan_13` varchar(20) NOT NULL,
  `pertanyaan_14` varchar(20) NOT NULL,
  `pertanyaan_15` varchar(20) NOT NULL,
  `pertanyaan_16` varchar(20) NOT NULL,
  `pertanyaan_17` varchar(20) NOT NULL,
  `pertanyaan_18` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tes`
--

INSERT INTO `tes` (`id_tes`, `id_user`, `pertanyaan_1`, `pertanyaan_2`, `pertanyaan_3`, `pertanyaan_4`, `pertanyaan_5`, `pertanyaan_6`, `pertanyaan_7`, `pertanyaan_8`, `pertanyaan_9`, `pertanyaan_10`, `pertanyaan_11`, `pertanyaan_12`, `pertanyaan_13`, `pertanyaan_14`, `pertanyaan_15`, `pertanyaan_16`, `pertanyaan_17`, `pertanyaan_18`) VALUES
(3, 1, 'ya', 'tidak', 'ya', 'tidak', 'ya', '', 'tidak', 'tidak', 'tidak', 'ya', 'ya', 'ya', 'tidak', 'tidak', 'ya', 'tidak', 'ya', 'ya'),
(4, 1, 'ya', 'tidak', 'ya', 'tidak', 'ya', '', 'tidak', 'tidak', 'tidak', 'ya', 'ya', 'ya', 'tidak', 'tidak', 'ya', 'tidak', 'ya', 'ya'),
(5, 1, 'ya', 'tidak', 'ya', 'tidak', 'ya', 'tidak', 'tidak', 'tidak', 'ya', 'ya', 'ya', 'tidak', 'tidak', 'ya', 'tidak', 'ya', 'ya', 'tidak'),
(6, 0, 'tidak', 'ya', '', 'tidak', 'ya', 'tidak', 'tidak', 'tidak', 'ya', 'ya', 'ya', 'tidak', 'tidak', 'ya', 'tidak', 'ya', 'ya', 'tidak'),
(7, 0, 'tidak', 'ya', 'tidak', 'ya', 'tidak', 'tidak', 'tidak', 'ya', 'ya', 'ya', 'tidak', 'tidak', 'ya', 'tidak', 'ya', 'ya', 'tidak', 'ya');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `gmail` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `nama`, `gmail`, `password`) VALUES
(1, 'abyan', 'abyan@gmail.com', '123'),
(2, 'aura', 'aura@gmail.com', '1234'),
(3, 'rifqi', 'rifqi@gmail.com', '12'),
(4, 'sania', 'sania@gmail.com', '333'),
(5, 'luthfi', 'luthfi@gmail.com', '444'),
(6, 'Hidananta', 'hidananta@gmail.com', '123'),
(7, 'mbok', 'mbok@gmail.com', '123'),
(8, '', '', ''),
(9, 'aldo', 'aldo@gmail.com', '123'),
(10, '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `hasil_tes`
--
ALTER TABLE `hasil_tes`
  ADD PRIMARY KEY (`id_hasil`);

--
-- Indeks untuk tabel `info_psikosomatis`
--
ALTER TABLE `info_psikosomatis`
  ADD PRIMARY KEY (`id_konten`);

--
-- Indeks untuk tabel `penanganan_ringan`
--
ALTER TABLE `penanganan_ringan`
  ADD PRIMARY KEY (`id_penanganan_ringan`);

--
-- Indeks untuk tabel `penanganan_sedang`
--
ALTER TABLE `penanganan_sedang`
  ADD PRIMARY KEY (`id_penanganan_sedang`);

--
-- Indeks untuk tabel `tenaga_medis`
--
ALTER TABLE `tenaga_medis`
  ADD PRIMARY KEY (`id_medis`);

--
-- Indeks untuk tabel `tes`
--
ALTER TABLE `tes`
  ADD PRIMARY KEY (`id_tes`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_user_2` (`id_user`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `hasil_tes`
--
ALTER TABLE `hasil_tes`
  MODIFY `id_hasil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `info_psikosomatis`
--
ALTER TABLE `info_psikosomatis`
  MODIFY `id_konten` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `penanganan_ringan`
--
ALTER TABLE `penanganan_ringan`
  MODIFY `id_penanganan_ringan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `penanganan_sedang`
--
ALTER TABLE `penanganan_sedang`
  MODIFY `id_penanganan_sedang` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tenaga_medis`
--
ALTER TABLE `tenaga_medis`
  MODIFY `id_medis` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tes`
--
ALTER TABLE `tes`
  MODIFY `id_tes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
