💼 Book Selling System — Modern Java Swing Desktop App Une application moderne et responsive pour gérer la vente de livres (neufs et d’occasion) avec Java Swing et MySQL. Elle propose une authentification utilisateur/admin, la gestion du catalogue, l’achat/les réservations, l’historique des commandes et un formulaire de contact. Optimisée pour un démarrage rapide sur desktop.

✨ Fonctionnalités

👤 Authentification utilisateur et administrateur
🗂️ Gestion des livres (ajout de livres neufs et d’occasion)
🛒 Parcours d’achat/réservation avec confirmations
📑 Historique des réservations/commandes
📬 Formulaire de demande/assistance (Request)
🖼️ Interface Swing soignée (boutons stylés, typographies lisibles)
🗄️ Persistance via MySQL (JDBC)
🔧 Code organisé par écrans (Admin/User) et utilitaires UI
🚀 Démarrage rapide

Prérequis

Java JDK 8+ (recommandé 11+)
MySQL 5.7+ ou 8.0+
MySQL Connector/J (fichier JAR du driver JDBC)
Installation

Cloner le dépôt
git clone https://github.com/your-username/book-selling-system.git
cd book-selling-system
Base de données
Créez une base: CREATE DATABASE book_selling_system CHARACTER SET utf8mb4;
Importez le schéma et les données: exécutez create_database.sql dans votre MySQL
Identifiants par défaut (exemple): admin / admin123 (peut être ajusté dans la BD)
Configuration JDBC
Vérifiez/modifiez l’URL JDBC, l’utilisateur et le mot de passe dans le code si nécessaire (ex: Userlogin.java)
URL par défaut: jdbc:mysql://localhost:3306/book_selling_system
Utilisateur: root
Mot de passe: (vide par défaut)
Compiler et lancer
Option A — Ligne de commande (Windows)

javac -cp .;path\to\mysql-connector-j.jar -d out *.java
Lancer l’écran de login utilisateur:
java -cp out;path\to\mysql-connector-j.jar Textbook_selling_system.Userlogin
Ou l’écran admin:
java -cp out;path\to\mysql-connector-j.jar Textbook_selling_system.AdminLogin
Option B — Ligne de commande (macOS/Linux)

javac -cp .:path/to/mysql-connector-j.jar -d out *.java
Lancer:
java -cp out:path/to/mysql-connector-j.jar Textbook_selling_system.Userlogin
