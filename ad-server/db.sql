CREATE DATABASE AdServer CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `ad` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `campaign_id` bigint(20) NOT NULL,
  `bid` double NOT NULL,
  `price` double NOT NULL,
  `brand` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `category` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `title` varchar(2048) COLLATE utf8mb4_unicode_ci NOT NULL,
  `keywords` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` MEDIUMTEXT COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `detail_url` MEDIUMTEXT COLLATE utf8mb4_unicode_ci NOT NULL,
  `thumbnail` MEDIUMTEXT COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `campaign` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `budget` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;