/*—---------------------------------------------------------------------*/
/*-----------------------------------------------------------------------*/
/*– sudah diupdate –*/



DROP DATABASE IF EXISTS perpustakaan;
CREATE DATABASE perpustakaan;

USE perpustakaan;


DROP TABLE IF EXISTS perpustakaan.tbl_tamu;
CREATE TABLE perpustakaan.tbl_tamu (
  `id` INT(11) COLLATE utf8mb4_unicode_ci NOT NULL AUTO_INCREMENT PRIMARY KEY, 
  `nama` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `asal` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `catatan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tanggal` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sort_id` INT(255) COLLATE utf8mb4_unicode_ci DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS perpustakaan.tbl_users;
CREATE TABLE perpustakaan.tbl_users (
  `id` INT(11) COLLATE utf8mb4_unicode_ci NOT NULL AUTO_INCREMENT PRIMARY KEY, 
  `nama` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `noid` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `peran` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `terakhir_login` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `jenis_kelamin` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL, 
  `no_tlp` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL, 
  `agama` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sort_id` INT(255) COLLATE utf8mb4_unicode_ci DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS perpustakaan.tbl_buku;
CREATE TABLE perpustakaan.tbl_buku (
  `id_buku` INT(255) COLLATE utf8mb4_unicode_ci NOT NULL, 
  `judul_buku` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `penulis_buku` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `penerbit_oleh` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tahun_buku` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nama_petugas_input` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sort_id` INT(255) COLLATE utf8mb4_unicode_ci NOT NULL AUTO_INCREMENT PRIMARY KEY
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS perpustakaan.tbl_pinjam;
CREATE TABLE perpustakaan.tbl_pinjam ( 
  `id_pinjam` INT(255) COLLATE utf8mb4_unicode_ci NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `id_buku` INT(255) COLLATE utf8mb4_unicode_ci, 
  `judul_buku` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status_buku` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT 'TIDAK DIPINJAM',
  `tgl_peminjaman` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL, 
  `tgl_pengembalian` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_user_peminjam` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT 'BELUM ADA',
  `sort_id` INT(255) COLLATE utf8mb4_unicode_ci DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*TIDAK DIPINJAM - DIPINJAM - DIKEMBALIKAN*/
/*id_buku dapat membedakan jumlah buku yang sama perbiji*/
/*kode_belakang_buku kemungkinan sama*/

/*saat meminjam (CREATE)= ++membuat id_pinjam + status_buku + input tgl_peminjaman saat ini + peminjam_terakhir*/
/*saat kembali (UPDATE)= mengambil id_pinjam ini + status_buku + input tgl_pengembalian saat ini*/

/*sistem DENDA dihitung saat (UPDATE) = tgl_pengembalian - tgl_peminjaman > BATAS DENDA*/

/*(DELETE) ketika Aplikasi dinyalakan akan menghapus riwayat peminjaman yang telah KEMBALI dari 1 tahun 6 bulan yang lalu*/




DROP TABLE IF EXISTS perpustakaan.tbl_kotakSaran;
CREATE TABLE perpustakaan.tbl_kotakSaran (
  `id` INT(11) COLLATE utf8mb4_unicode_ci NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nama` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `saran` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tanggal` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sort_id` INT(255) COLLATE utf8mb4_unicode_ci DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Setelah table Pengembalian -> Denda -> KotakSaran*/



/*
DROP TABLE IF EXISTS perpustakaan.tbl_pengumuman;
CREATE TABLE perpustakaan.tbl_pengumuman (
  `id` INT(11) COLLATE utf8mb4_unicode_ci NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nama_petugas_input` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pengumuman` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tanggal` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
*/
/*Menu Awal Tombol Baru Pengumuman*/
/*jtable dengan 2 COLUMN (pengumuman-tanggal) dan ROW yang besar.*/










/*-- INPUT -------------------------------------------------------------*/

INSERT INTO `tbl_users`(`id`, `nama`, `email`, `password`, `noid`, `peran`, `terakhir_login`, `jenis_kelamin`, `no_tlp`, `agama`, `alamat`,`sort_id`) VALUES 
(NULL,"admin","admin@email.com","admin","201943500000","ADMIN","2010","LAKI-LAKI","088212789","-","J. Swadaya II No.30, Tanjung Barat, Jagakarsa, Jakarta Selatan, DKI Jakarta", NULL);

/*
INSERT INTO `tbl_users`(`id`, `nama`, `email`, `password`, `noid`, `peran`, `terakhir_login`, `jenis_kelamin`, `no_tlp`, `agama`, `alamat`) VALUES 
(NULL,"rijani","rijani@email.com","rijani","201943500000","GURU","2010","PEREMPUAN","088212789","","Jl.Gurame Bawal Teri"),
(NULL,"Asep","asep@email.com","asep","201943500000","SISWA","2010","LAKI-LAKI","088212789","","Jl.Gurame Bawal Teri");
*/
/*—---------------------------------------------------------------------*/


/*-- INPUT -------------------------------------------------------------*/
/* 
INSERT INTO `tbl_buku` (`id_buku`, `judul_buku`, `penulis_buku`, `penerbit_oleh`, `tahun_buku`, `nama_petugas_input`) VALUES 
(NULL, 'buku1', 'penulis admin', 'teknik', '2022', 'admin'),
(NULL, 'buku2', 'penulis admin', 'informatika', '2022', 'admin');
*/
/*—---------------------------------------------------------------------*/

/*
INSERT INTO `tbl_pinjam` (`id_pinjam`, `id_buku`, `judul_buku`, `status_buku`, `tgl_peminjaman`, `tgl_pengembalian`, `id_user_peminjam`) VALUES
(1, 1, 'buku1', 'DIPINJAM', '2020/03/19 15:28:19', '0', '1'),
(2, 2, 'buku2', 'DIKEMBALIKAN', '2022/06/29 15:28:28', '2022/06/29 15:28:32', '1'),
(3, 1, 'buku1', 'DIPINJAM', '2020/03/19 15:28:19', '0', '1');



INSERT INTO `tbl_kotaksaran` (`id`, `nama`, `saran`, `tanggal`) VALUES 
(1, 'admin', 'Terimakasih', '2022/06/29 15:28:41');


INSERT INTO `tbl_tamu` (`id`, `nama`, `asal`, `catatan`, `tanggal`) VALUES 
(1, 'admin', 'R6U', 'Insert data', '2022/06/29 15:25:22');
*/

/*—---------------------------------------------------------------------*/


