USBC�D�     
*  ���         :                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ALTER TABLE perpustakaan.tbl_buku DROP IF EXISTS sort_id;
ALTER TABLE perpustakaan.tbl_buku ADD sort_id INT(255) COLLATE utf8mb4_unicode_ci NOT NULL AUTO_INCREMENT;
ALTER TABLE perpustakaan.tbl_kotaksaran DROP IF EXISTS sort_id;
ALTER TABLE perpustakaan.tbl_kotaksaran ADD sort_id INT(255) COLLATE utf8mb4_unicode_ci NOT NULL AUTO_INCREMENT;
ALTER TABLE perpustakaan.tbl_pinjam DROP IF EXISTS sort_id;
ALTER TABLE perpustakaan.tbl_pinjam ADD sort_id INT(255) COLLATE utf8mb4_unicode_ci NOT N