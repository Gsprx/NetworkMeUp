# NetworkMeUp - Εφαρμογή εύρεσης εργασίας

## Απαιτήσεις εφαρμογής

Η εφαρμογή στοχεύει στη διευκόλυνση της διαδικασίας εύρεσης εργασίας και τη δημιουργία ενός διαύλου επικοινωνίας μεταξύ των εργοδοτών και των ενδιαφερόμενων εργαζομένων. Οι χρήστες της παραπάνω εφαρμογής χωρίζονται σε δύο κατηγορίες, τους εργοδότες και τους εργαζομένους, για τους οποίους απαιτείται η εγγραφή στο σύστημα. Επιπλέον οι χρήστες έχουν την δυνατότητα να διαχειριστούν τα διάφορα στοιχεία των λογαριασμών τους.

Μέσα από την εφαρμογή αυτή οι εργαζόμενοι θα είναι σε θέση να ανεβάσουν το βιογραφικό τους στο σύστημα, να αναζητήσουν θέσεις εργασίας και να εκδηλώσουν το ενδιαφέρον τους. Κάθε εργαζόμενος θα έχει τη δυνατότητα να μεταβάλλει τις πληροφορίες του βιογραφικού του ανά πάσα στιγμή. Το σύστημα, από την πλευρά του, θα εμφανίζει στον ενδιαφερόμενο μόνο θέσεις εργασίας που ταιριάζουν με το βιογραφικό του, δηλαδή θέσεις που είναι ικανός να εργαστεί, αποφεύγοντας έτσι άσκοπες υποβολές αιτημάτων.

Από την άλλη πλευρά, οι εργοδότες θα μπορούν να ανεβάζουν θέσεις εργασίας, οι οποίες θα περιλαμβάνουν κατάλληλα δεδομένα, έτσι ώστε να διευκολύνεται η αυτοματοποιημένη αντιστοίχισή τους με βιογραφικά εργαζομένων (απαιτούμενο πτυχίο/πτυχία, ξένες γλώσσες). Θα είναι σε θέση, επίσης, να προβάλλουν τα βιογραφικά που έχουν υποβληθεί για κάθε θέση εργασίας και να τα απορρίπτουν ή να καλούν τους εργαζομένους για συνέντευξη. Το σύστημα, από την πλευρά του, θα εμφανίζει στατιστικά στοιχεία προς τους εργοδότες όπως πλήθος αιτημάτων ανά θέση εργασίας, πλήθος αιτημάτων ανά τομέα που ανήκει η κάθε θέση εργασίας κτλ...

Το σύστημα θα υλοποιεί την αναζήτηση εργασίας μέσω σύγκρισης των πρωτεύοντων ικανοτήτων του κάθε βιογραφικού (τα πτυχία με τους τομείς τους καθώς και τις γνώσεις ξένων γλωσσών) με τις αντίστοιχες βασικές απαιτήσεις της θέσης εργασίας για το matching τους.
Έτσι, λοιπόν, οι εργαζόμενοι θα έχουν τη δυνατότητα να έχουν πρόσβαση σε μια μεγάλη γκάμα θέσεων εργασίας και να υποβάλλουν αίτηση σε εκείνες τις αρέσκειάς τους, ενώ οι εργοδότες θα μπορούν να καλύπτουν τις διαθέσιμες ειδικότητες με τους καταλληλότερους υποψηφίους. 

## Εμβέλεια

\[*Περιγράφουμε τι θα κάνει και κυρίως τι δεν θα κάνει το λογισμικό. Βλέπε παράδειγμα 3-2 του βιβλίου στη σελίδα 139.*

*Ένα διάγραμμα περιβάλλοντος (πρωταρχικό διάγραμμα ροής δεδομένων) που βοηθά στην κατανόηση του συστήματος σε σχέση με το περιβάλλον του. Βλέπε το σχήμα 4-12 του παραδείγματος 4-1 στη σελίδα 185 του βιβλίου*\]

## Ορισμοί ακρώνυμα και συντομογραφίες

\[*Ένας πίνακας ακρωνύμων και συντομογραφιών που χρησιμοποιούνται στο έγγραφο. Ένας δεύτερος πίνακας με ορισμούς. Οι ορισμοί λαμβάνονται από το γλωσσάρι αν αυτό υπάρχει. Βλέπε πίνακα 3-5 του παραδείγματος 3-1 στη σελίδα 134.*\]

## Επισκόπηση

\[*Γράφουμε πως οργανώνεται το υπόλοιπο έγγραφο*\]

# Συνολική περιγραφή

## Επισκόπηση μοντέλου περιπτώσεων χρήσης

![Διάγραμμα περιπτώσεων χρήσης](docs/images/use-case.png)

## Υποθέσεις και εξαρτήσεις

Το σύστημα υποθέτει πως όλες οι πληροφορίες που παρέχονται από τους χρήστες του είναι αληθής και ταυτόχρονα πως τα ενδιαφέροντα, μαζί με τις θέσεις εργασίας, είναι πραγματικά. Επιπλέον το σύστημα εξαρτάρται από την ορθή χρήση του, από τους χρήστες του, ώστε να παρέχει ένα πλούσιο σε ποικιλία περιβάλλον διασύνδεσης, στα πλαίσια της εργασίας.

# Ειδικές Απαιτήσεις 

## Περιπτώσεις χρήσης

### Οι ενδιαφερόμενοι και οι ανάγκες τους

| Ενδιαφερόμενοι   | Ανάγκες  |
| :------: | :-------- |
|Εργαζόμενος| Εύρεση εργασίας που συμπίπτει σε μεγάλο βαθμό με τις ικανότητές του, τις απαιτήσεις του, και τα ενδιαφέροντά του|
|Εργοδότης| Πρόσληψη των πιο κατάλληλων εργαζομένων για τις διάφορες θέσεις εργασίας της εταιρίας του| 
|Ανώτερο Στέλεχος Εταιρίας| Εύρεση εργαζομένων με προδιαγραφές πιο σχετικές για την εταιρία και την συγκεκριμένη θέση εργασίας

### Actors του συστήματος
| Actor    | Περιγραφή  | Στόχοι |
| :------: | :---------: | :------: |
|Εργαζόμενος| Αναζητεί εργασία που ταιριάζει στα ενδιαφέροντά του| Αναζήτηση Εργασίας, Κοινοποίηση και Επεξεργασία Βιογραφικού|
|Εργοδότης| Αναζητεί κατάλληλους υπαλλήλους για τις διάφορες θέσεις εργασίας που προσφέρει| Επεξεργασία αιτημάτων εργασίας, Διαχείριση Θέσεων Εργασίας|

### Περιγραφές περιπτώσεων χρήσης
| Περίπτωση Χρήσης   | Περιγραφή   |
| :------:           | :---------: |
|ΠΧ1. Business Account Management| Η περίπτωση χρήσης για την δημιουργία ή επεξεργασίας ενός εταιρικού λογαριασμού στο σύστημα|
|ΠΧ2. Employee Account Management| Η περίπτωση χρήσης για την δημιουργία ή επεξεργασίας ενός εργατικού λογαριασμού στο σύστημα|
|ΠΧ3. Update Job Applications| Η περίπτωση χρήσης για την αποδοχή ή άρνηση εισερχομένων αιτήσεων δουλειάς από εργαζομένους|
|ΠΧ4. Manage Job Positions| Η περίπτωση χρήσης για την προσθήκη ή επεξεργασία υπάρχουσων θέσεων εργασίας|
|ΠΧ5. Modify CV| Η περίπτωση χρήσης για την κοινοποίηση ή τροποποίηση του βιογραφικού του εργαζομένου|
|ΠΧ6. Job Research| Η περίπτωση χρήσης για την αναζήτηση θέσεων εργασίας που συμπίπτει, έως ένα βαθμό, με τις ικανότητες και τα ενδιαφέροντα του εργαζομένου|

#### [ΠΧ1 Διαχείριση Εταιρικού Λογαριασμού](uc1-business-account-management.md)

#### [ΠΧ2 Διαχείριση Εργατικού Λογαριασμού](uc2-employee-account-management.md)

#### [ΠΧ3 Επεξεργασία Αιτημάτων Εργασίας](uc3-update-job-applications.md)

#### [ΠΧ4 Διαχείριση Θέσεων Εργασίας](uc4-manage-job-positions.md)

#### [ΠΧ5 Διαχείριση Βιογραφικού](uc5-modify-cv.md)

#### [ΠΧ6 Αναζήτηση Εργασίας](uc6-job-research.md)

## Συμπληρωματικές προδιαγραφές

\[*Οι επόμενες ενότητες περιέχουν όλες τις μη λειτουργικές απαιτήσεις και τους περιορισμούς σχεδίασης και υλοποίησης.*\]

### Απαιτήσεις διεπαφών

#### Διεπαφές χρήστη

* Όλες οι διεπαφές χρήστη θα είναι application based.
* Κάθε λειτουργία θα συνόδευεται από ειδικό κουμπί βοήθειας που θα εξηγεί τη χρήση της.


#### Διεπαφές επικοινωνίας

* Το σύστημα θα στέλνει ενημερωτικά ηλεκτρονικά μηνύματα για εξελίξεις των αιτημάτων εργασίας.

#### Διεπαφές λογισμικού

* Για την αποστολή των ηλεκτρονικών μηνυμάτων το σύστημα θα επικοινωνεί με τον διακομιστή ηλεκτρονικού ταχυδρομείου του κάθε χρήστη.

### Περιορισμοί σχεδίασης και υλοποίησης

#### Βάσεις Δεδομένων

* Το σύστημα θα πρέπει να υποστηρίζει τα σχεσιακά συστήματα διαχείρισης βάσεων δεδομένων MySQL.

#### Java

* Το σύστημα θα αναπτυχθεί Java.
* Το σύστημα θα μπορεί να εκτελείται σε εικονικές μηχανές της Java από την έκδοση 8 ή νεότερη.

### Ποιοτικά χαρακτηριστικά

#### Απόδοση

* Το σύστημα θα πρέπει να υποστηρίζει πολλούς ταυτόχρονους χρήστες.
* Η απόκριση της βάσης δεδομένων σε κάθε ενέργεια δε θα ξεπερνά τα είκοσι (20) δευτερόλεπτα.

#### Διαθεσιμότητα

* Το σύστημα θα είναι διαθέσιμο 24 ώρες για 7 ημέρες της εβδομάδας.

#### Ασφάλεια

* Όλες οι λειτουργίες θα πραγματοποιούνται με διαδικασία αυθεντικοποίσης. 

#### Ευελιξία

* Ενδεχόμενη προσαρμογή του συστήματος σε ένα νέο σύστημα διαχείρισης βάσεων δεδομένων δεν θα πρέπει να ξεπερνά τις 20 ημέρες.

#### Ευχρηστία

* Το σύστημα δεν προϋποθέτει γνώσεις πέρα από τις βασικές ικανότητες εφαρμογών αφής.
* Όλες οι διαδικασίες είναι απλοποιημένες και περιέχουν επιλογή βοήθειας - εξήγησής τους.

# Υποστηρικτικό υλικό

## Μοντέλο πεδίου

![Μοντέλο Πεδίου](docs/images/class_diagram.png)

## Ανάλυση περιπτώσεων χρήσης
--------------------------

### Κλάσεις ανάλυσης

![Κλάσεις Ανάλυσης](docs/images/class_analysis.png)

Κλάσεις ανάλυσης που έχουν προκύψει από την ανάλυση των περιπτώσεων χρήσης *Διαχείριση Εταιρικού Λογαριασμού*, *Διαχείριση Εργατικού Λογαριασμού*, *Διαχείριση Βιογραφικού* και *Διαχείριση Θέσεων Εργασίας*.

### Συμπεριφορές

\[*Για κάθε σημαντική περίπτωση χρήσης εισάγουμε ένα διάγραμμα κλάσεων με τις κλάσεις που συμμετέχουν στη συμπεριφορά του συστήματος για την περίπτωση χρήσης. Το σημαντικότερο όμως είναι ένα διάγραμμα επικοινωνίας ή ακολουθίας που δείχνει την ανταλλαγή μηνυμάτων.*

*Βλέπε το παράδειγμα 4-16 στη σελίδα 262 του βιβλίου*\]

#### Περιπτώσεις χρήσης εργοδοτών

![Διάγραμμα ακολουθίας - Εργοδότης](docs/images/Employer_sequence_diagram.png)

#### Περιπτώσεις χρήσης εργαζομένων

![Διάγραμμα ακολουθίας - Εργαζόμενος](docs/images/Employee_sequence_diagram.png)

## Άλλα μοντέλα
------------

\[*Άλλα μοντέλα όπως για παράδειγμα διαγράμματα μηχανής καταστάσεων, πίνακες απόφασης κλπ. Βλέπε παράδειγμα 4-6 του βιβλίου*\]

## <a id="business-rules"></a>Επιχειρησιακοί κανόνες

| Επιχειρησιακοί κανόνες | Περιγραφή |
| :----------------------| :---------|
| ΕΚ1 |  Η ηλικία του χρήστη θα πρέπει να είναι μεγαλύτερη των 18 ετών.
| EK2 | Κάθε λογαριασμός θα πρέπει να έχει μοναδικό email και τηλέφωνο.