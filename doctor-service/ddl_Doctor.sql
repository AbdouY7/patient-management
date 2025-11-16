CREATE TABLE public.doctor
(
    doctor_id  UUID NOT NULL,
    name       VARCHAR(255),
    email      VARCHAR(255),
    phone      VARCHAR(255),
    speciality VARCHAR(255),
    CONSTRAINT pk_doctor PRIMARY KEY (doctor_id)
);
INSERT INTO doctor (doctor_id, name, email, phone, speciality) VALUES
                                                                                        ('550e8400-e29b-41d4-a716-446655440001', 'Amina Benali', 'amina.benali@hospital.com', '+213661223344', 'Cardiology'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440002', 'Karim Boumediene', 'karim.boumediene@hospital.com', '+213669112233', 'Neurology'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440003', 'Nadia Saadi', 'nadia.saadi@hospital.com', '+213667445566', 'Pediatrics'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440004', 'Yacine Cherif', 'yacine.cherif@hospital.com', '+213665778899', 'Dermatology'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440005', 'Rania Tlemcani', 'rania.tlemcani@hospital.com', '+213662112233', 'Ophthalmology'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440006', 'Hichem Zerrouki', 'hichem.zerrouki@hospital.com', '+213664998877', 'Orthopedics'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440007', 'Lina Khaldi', 'lina.khaldi@hospital.com', '+213663334455', 'Dentistry'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440008', 'Sofiane Mokadem', 'sofiane.mokadem@hospital.com', '+213665889900', 'General Surgery'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440009', 'Farida Ammar', 'farida.ammar@hospital.com', '+213668445566', 'Gynecology'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440010', 'Rachid Hamza', 'rachid.hamza@hospital.com', '+213661778899', 'Psychiatry'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440011', 'Imane Boudjemaa', 'imane.boudjemaa@hospital.com', '+213661234567', 'Endocrinology'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440012', 'Sami Belkacem', 'sami.belkacem@hospital.com', '+213662345678', 'Radiology'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440013', 'Salima Kerroum', 'salima.kerroum@hospital.com', '+213663456789', 'Hematology'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440014', 'Nourredine Fekir', 'nourredine.fekir@hospital.com', '+213664567890', 'Urology'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440015', 'Sabrina Touati', 'sabrina.touati@hospital.com', '+213665678901', 'Anesthesiology'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440016', 'Youssef Bencherif', 'youssef.bencherif@hospital.com', '+213666789012', 'Gastroenterology'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440017', 'Sara Mekki', 'sara.mekki@hospital.com', '+213667890123', 'Otolaryngology'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440018', 'Fares Djahid', 'fares.djahid@hospital.com', '+213668901234', 'Pulmonology'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440019', 'Leila Hachemi', 'leila.hachemi@hospital.com', '+213669012345', 'Rheumatology'),
                                                                                        ('550e8400-e29b-41d4-a716-446655440020', 'Amine Bensalem', 'amine.bensalem@hospital.com', '+213660123456', 'Nephrology');
