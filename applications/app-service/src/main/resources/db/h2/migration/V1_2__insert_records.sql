INSERT INTO Movies (imdbID, title, description)
VALUES
  ('tt0232500', 'The Fast and the Furious', 'Los Angeles police officer Brian O''Conner must decide where his loyalty really lies when he becomes enamored with the street racing world he has been sent undercover to destroy.'),
  ('tt0322259', 'T2 Fast 2 Furious', 'Former cop Brian O''Conner is called upon to bust a dangerous criminal and he recruits the help of a former childhood friend and street racer who has a chance to redeem himself.'),
  ('tt0463985', 'The Fast and the Furious: Tokyo Drift', 'A teenager becomes a major competitor in the world of drift racing after moving in with his father in Tokyo to avoid a jail sentence in America.'),
  ('tt1013752', 'Fast & Furious', 'Brian O''Conner, back working for the FBI in Los Angeles, teams up with Dominic Toretto to bring down a heroin importer by infiltrating his operation.'),
  ('tt1596343', 'Fast Five', 'Dominic Toretto and his crew of street racers plan a massive heist to buy their freedom while in the sights of a powerful Brazilian drug lord and a dangerous federal agent.'),
  ('tt1905041', 'Fast & Furious 6', 'Hobbs has Dominic and Brian reassemble their crew to take down a team of mercenaries: Dominic unexpectedly gets sidetracked with facing his presumed deceased girlfriend, Letty.'),
  ('tt2820852', 'Furious 7', 'Deckard Shaw seeks revenge against Dominic Toretto and his family for his comatose brother'),
  ('tt4630562', 'The Fate of the Furious', 'When a mysterious woman seduces Dominic Toretto into the world of terrorism and a betrayal of those closest to him, the crew face trials that will test them as never before.'),
  ('tt5433138', 'F9: The Fast Saga', 'Dom and the crew must take on an international terrorist who turns out to be Dom and Mia''s estranged brother.');

INSERT INTO Schedule (id, movie_id, date_schedule, price)
VALUES
  (1, 'tt0232500', '2023-11-10 18:00:00', 10900),
  (2, 'tt0232500', '2023-11-10 12:00:00', 11900),
  (3, 'tt0232500', '2023-11-10 13:00:00', 11900),
  (4, 'tt0322259', '2023-11-10 20:00:00', 10900),
  (5, 'tt0322259', '2023-11-10 20:30:00', 10900),
  (6, 'tt0322259', '2023-11-10 21:40:00', 10900),
  (7, 'tt0463985', '2023-11-10 21:00:00', 10900),
  (8, 'tt0463985', '2023-11-10 10:45:00', 10900),
  (9, 'tt1013752', '2023-11-10 21:20:00', 10900),
  (10, 'tt1013752', '2023-11-10 11:15:00', 11900),
  (11, 'tt1596343', '2023-11-10 22:30:00', 10900),
  (12, 'tt1596343', '2023-11-10 12:00:00', 10900),
  (13, 'tt1905041', '2023-11-10 22:00:00', 11900),
  (14, 'tt1905041', '2023-11-10 14:30:00', 11900),
  (15, 'tt2820852', '2023-11-10 19:00:00', 10900),
  (16, 'tt2820852', '2023-11-10 15:45:00', 11900),
  (17, 'tt4630562', '2023-11-10 17:00:00', 11900),
  (18, 'tt4630562', '2023-11-10 13:00:00', 11900);

INSERT INTO Rate (movie_id, rating, comment, date_rate)
VALUES
  ('tt0232500', 9, 'Buena película', '2023-01-01 20:30:00'),
  ('tt0322259', 8, 'Me gustó', '2023-01-02 22:15:00');