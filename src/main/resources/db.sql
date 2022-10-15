USE [g3movietheater]
GO
SET IDENTITY_INSERT [movie_theater].[roles] ON
GO
INSERT [movie_theater].[roles] ([role_id], [role_name]) VALUES (1, N'ROLE_ADMIN')
GO
INSERT [movie_theater].[roles] ([role_id], [role_name]) VALUES (2, N'ROLE_USER')
GO
SET IDENTITY_INSERT [movie_theater].[roles] OFF
GO
INSERT [movie_theater].[account] ([account_id], [address], [date_of_birth], [email], [full_name], [gender], [identity_card], [image], [password], [phone_number], [register_date], [status], [username], [role_id]) VALUES (N'2', N'quat lam', CAST(N'2008-10-10T00:00:00.000' AS DateTime), N'chuong2@gmail.com', N'Admin 122', N'M', N'122', N'profile1', N'$10$32S8vE0sFBbyIq68fB.lQeOW9F7vXhSbcpMX7NvdNI9WXb1ohZuyi', N'0999999999', CAST(N'2007-09-09T00:00:00.000' AS DateTime), 1, N'admin123', 1)
GO
INSERT [movie_theater].[account] ([account_id], [address], [date_of_birth], [email], [full_name], [gender], [identity_card], [image], [password], [phone_number], [register_date], [status], [username], [role_id]) VALUES (N'3', N'quat lam', CAST(N'2008-10-10T00:00:00.000' AS DateTime), N'chuong2@gmail.com', N'do nhu the', N'M', N'121', N'image2', N'$10$32S8vE0sFBbyIq68fB.lQeOW9F7vXhSbcpMX7NvdNI9WXb1ohZuyi', N'111111', CAST(N'2007-09-09T00:00:00.000' AS DateTime), 1, N'admin2', 1)
GO
INSERT [movie_theater].[account] ([account_id], [address], [date_of_birth], [email], [full_name], [gender], [identity_card], [image], [password], [phone_number], [register_date], [status], [username], [role_id]) VALUES (N'4', N'quat lam', CAST(N'2008-10-10T00:00:00.000' AS DateTime), N'chuong2@gmail.com', N'do nhu the', N'M', N'111', N'image2', N'$10$32S8vE0sFBbyIq68fB.lQeOW9F7vXhSbcpMX7NvdNI9WXb1ohZuyi', N'111111', CAST(N'2007-09-09T00:00:00.000' AS DateTime), 1, N'admin3', 1)
GO
INSERT [movie_theater].[account] ([account_id], [address], [date_of_birth], [email], [full_name], [gender], [identity_card], [image], [password], [phone_number], [register_date], [status], [username], [role_id]) VALUES (N'7', N'quat lam', CAST(N'2008-10-10T00:00:00.000' AS DateTime), N'chuong2@gmail.com', N'do nhu the', N'M', N'423', N'image2', N'$10$32S8vE0sFBbyIq68fB.lQeOW9F7vXhSbcpMX7NvdNI9WXb1ohZuyi', N'111111', CAST(N'2007-09-09T00:00:00.000' AS DateTime), 1, N'admin6', 1)
GO
INSERT [movie_theater].[account] ([account_id], [address], [date_of_birth], [email], [full_name], [gender], [identity_card], [image], [password], [phone_number], [register_date], [status], [username], [role_id]) VALUES (N'8', N'quat lam', CAST(N'2008-10-10T00:00:00.000' AS DateTime), N'chuong2@gmail.com', N'do nhu the', N'M', N'583', N'image2', N'$2a$10$32S8vE0sFBbyIq68fB.lQeOW9F7vXhSbcpMX7NvdNI9WXb1ohZuyi', N'111111', CAST(N'2007-09-09T00:00:00.000' AS DateTime), 0, N'thang', 2)
GO
INSERT [movie_theater].[account] ([account_id], [address], [date_of_birth], [email], [full_name], [gender], [identity_card], [image], [password], [phone_number], [register_date], [status], [username], [role_id]) VALUES (N'G3_0000001', N'namdinh', CAST(N'2008-11-10T00:00:00.000' AS DateTime), N'chuong1@gmail.com', N'hoang van chuong', N'M', N'123456', N'9007039cf556451ab6cec4d39185b698.jpg', N'$2a$10$32S8vE0sFBbyIq68fB.lQeOW9F7vXhSbcpMX7NvdNI9WXb1ohZuyi', N'0999999999', CAST(N'2008-11-11T00:00:00.000' AS DateTime), 1, N'admin', 1)
GO
INSERT [movie_theater].[account] ([account_id], [address], [date_of_birth], [email], [full_name], [gender], [identity_card], [image], [password], [phone_number], [register_date], [status], [username], [role_id]) VALUES (N'G3_0000002', N'quat lam', CAST(N'1999-10-10T00:00:00.000' AS DateTime), N'chuong2@gmail.com', N'do nhu the', N'M', N'234557', N'image2', N'$2a$10$32S8vE0sFBbyIq68fB.lQeOW9F7vXhSbcpMX7NvdNI9WXb1ohZuyi', N'111111', CAST(N'1999-11-11T00:00:00.000' AS DateTime), 1, N'user', 2)
GO
INSERT [movie_theater].[account] ([account_id], [address], [date_of_birth], [email], [full_name], [gender], [identity_card], [image], [password], [phone_number], [register_date], [status], [username], [role_id]) VALUES (N'G3_0000003', N'41 Dong Tac Ha Noi', CAST(N'1888-08-09T00:00:00.000' AS DateTime), N'chuong@gmail.com', N'Chuong Hoang', N'M', N'111111', N'75bad8451b1e4633a488be60c690b443.jpg', N'$2a$10$32S8vE0sFBbyIq68fB.lQeOW9F7vXhSbcpMX7NvdNI9WXb1ohZuyi', N'+40983012664', CAST(N'2018-11-11T00:00:00.000' AS DateTime), 1, N'chuong', 1)
GO
INSERT [movie_theater].[account] ([account_id], [address], [date_of_birth], [email], [full_name], [gender], [identity_card], [image], [password], [phone_number], [register_date], [status], [username], [role_id]) VALUES (N'G3_0000004', N'giao yen ', CAST(N'2008-10-10T00:00:00.000' AS DateTime), N'dieu@gmail.com', N'do vinh ', N'F', N'000000', N'image2', N'$2a$10$32S8vE0sFBbyIq68fB.lQeOW9F7vXhSbcpMX7NvdNI9WXb1ohZuyi', N'111111', CAST(N'2007-09-09T00:00:00.000' AS DateTime), 1, N'admin4', 1)
GO
INSERT [movie_theater].[account] ([account_id], [address], [date_of_birth], [email], [full_name], [gender], [identity_card], [image], [password], [phone_number], [register_date], [status], [username], [role_id]) VALUES (N'G3_0000005', N'ha noi ', CAST(N'2008-10-10T00:00:00.000' AS DateTime), N'kien@gmail.com', N'hao an ', N'F', N'111111', N'image2', N'pass', N'111111', CAST(N'2007-09-09T00:00:00.000' AS DateTime), 1, N'admin5', 1)
GO
INSERT [movie_theater].[account] ([account_id], [address], [date_of_birth], [email], [full_name], [gender], [identity_card], [image], [password], [phone_number], [register_date], [status], [username], [role_id]) VALUES (N'G3_0000008', N'hai an ', CAST(N'1983-10-10T00:00:00.000' AS DateTime), N'chuong8@gmail.com', N'trung kien ', N'M', N'111111', N'image2', N'pass', N'111111', CAST(N'2007-09-09T00:00:00.000' AS DateTime), 1, N'admin8', 1)
GO
SET IDENTITY_INSERT [movie_theater].[schedule] ON
GO
INSERT [movie_theater].[schedule] ([schedule_id], [schedule_time]) VALUES (1, N'07:00')
GO
INSERT [movie_theater].[schedule] ([schedule_id], [schedule_time]) VALUES (2, N'09:00')
GO
INSERT [movie_theater].[schedule] ([schedule_id], [schedule_time]) VALUES (3, N'11:00')
GO
INSERT [movie_theater].[schedule] ([schedule_id], [schedule_time]) VALUES (4, N'13:00')
GO
INSERT [movie_theater].[schedule] ([schedule_id], [schedule_time]) VALUES (5, N'14:00')
GO
INSERT [movie_theater].[schedule] ([schedule_id], [schedule_time]) VALUES (6, N'15:00')
GO
INSERT [movie_theater].[schedule] ([schedule_id], [schedule_time]) VALUES (7, N'16:00')
GO
INSERT [movie_theater].[schedule] ([schedule_id], [schedule_time]) VALUES (8, N'17:00')
GO
INSERT [movie_theater].[schedule] ([schedule_id], [schedule_time]) VALUES (9, N'18:00')
GO
INSERT [movie_theater].[schedule] ([schedule_id], [schedule_time]) VALUES (10, N'19:00')
GO
INSERT [movie_theater].[schedule] ([schedule_id], [schedule_time]) VALUES (11, N'20:00')
GO
INSERT [movie_theater].[schedule] ([schedule_id], [schedule_time]) VALUES (12, N'21:00')
GO
INSERT [movie_theater].[schedule] ([schedule_id], [schedule_time]) VALUES (13, N'22:00')
GO
INSERT [movie_theater].[schedule] ([schedule_id], [schedule_time]) VALUES (14, N'23:00')
GO
SET IDENTITY_INSERT [movie_theater].[schedule] OFF
GO
SET IDENTITY_INSERT [movie_theater].[cinema_room] ON
GO
INSERT [movie_theater].[cinema_room] ([cinema_room_id], [cinema_room_name], [cinema_image], [seat_quantity]) VALUES (1, N'room1', NULL, 60)
GO
INSERT [movie_theater].[cinema_room] ([cinema_room_id], [cinema_room_name], [cinema_image], [seat_quantity]) VALUES (2, N'Room 1', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_1fMl2BZ7OIpLPK5F9BHmqTa1aBIhXqtFpw&usqp=CAU', 50)
GO
INSERT [movie_theater].[cinema_room] ([cinema_room_id], [cinema_room_name], [cinema_image], [seat_quantity]) VALUES (3, N'Room 2', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_1fMl2BZ7OIpLPK5F9BHmqTa1aBIhXqtFpw&usqp=CAU', 50)
GO
INSERT [movie_theater].[cinema_room] ([cinema_room_id], [cinema_room_name], [cinema_image], [seat_quantity]) VALUES (4, N'Room 3', N'https://i.pinimg.com/474x/c1/3c/11/c13c11ec72e83fc8521893d53ec35623.jpg', 60)
GO
INSERT [movie_theater].[cinema_room] ([cinema_room_id], [cinema_room_name], [cinema_image], [seat_quantity]) VALUES (5, N'Room 4', N'https://i.pinimg.com/474x/c1/3c/11/c13c11ec72e83fc8521893d53ec35623.jpg', 50)
GO
INSERT [movie_theater].[cinema_room] ([cinema_room_id], [cinema_room_name], [cinema_image], [seat_quantity]) VALUES (6, N'Room 5', N'https://i.pinimg.com/474x/c1/3c/11/c13c11ec72e83fc8521893d53ec35623.jpg', 60)
GO
INSERT [movie_theater].[cinema_room] ([cinema_room_id], [cinema_room_name], [cinema_image], [seat_quantity]) VALUES (7, N'Room 6', N'https://i.pinimg.com/474x/c1/3c/11/c13c11ec72e83fc8521893d53ec35623.jpg', 50)
GO
INSERT [movie_theater].[cinema_room] ([cinema_room_id], [cinema_room_name], [cinema_image], [seat_quantity]) VALUES (8, N'vip01', N'/resources/img/room/4.jpg', 60)
GO
SET IDENTITY_INSERT [movie_theater].[cinema_room] OFF
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'1', N'Actor', N'Shang-Chi Và Huyền Thoại Thập Luân', N'ch', 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), NULL, N'Shang-Chi and The Legend of The Ten Rings', N'Shang-Chi Và Huyền Thoại Thập Luân', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'10', N'Actor', N'Black Window: Goá Phụ Đen', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'black_widow.jpg', N'Black Window', N'
Black Window: Goá Phụ Đen', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'11', N'Actor', N'
Shang-Chi Và Huyền Thoại Thập Luân', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'poster_shangchi.jpg', N'Shang-Chi and The Legend of The Ten Rings', N'
Shang-Chi Và Huyền Thoại Thập Luân', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'12', N'Actor', N'Black Window: Goá Phụ Đen', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'black_widow.jpg', N'Black Window', N'
Black Window: Goá Phụ Đen', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'13', N'Actor', N'
Shang-Chi Và Huyền Thoại Thập Luân', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'poster_shangchi.jpg', N'Shang-Chi and The Legend of The Ten Rings', N'
Shang-Chi Và Huyền Thoại Thập Luân', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'14', N'Actor', N'Black Window: Goá Phụ Đen', N'chuong', 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'/resources/img/movie/4.jpg', N'Black Window', N'Black Window: Goá Phụ Đen', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'15', N'Actor', N'
Shang-Chi Và Huyền Thoại Thập Luân', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'poster_shangchi.jpg', N'Shang-Chi and The Legend of The Ten Rings', N'
Shang-Chi Và Huyền Thoại Thập Luân', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'16', N'Actor', N'Black Window: Goá Phụ Đen', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'black_widow.jpg', N'Black Window', N'
Black Window: Goá Phụ Đen', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'17', N'Actor', N'
Shang-Chi Và Huyền Thoại Thập Luân', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'poster_shangchi.jpg', N'Shang-Chi and The Legend of The Ten Rings', N'
Shang-Chi Và Huyền Thoại Thập Luân', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'18', N'Actor', N'Black Window: Goá Phụ Đen', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'black_widow.jpg', N'Black Window', N'
Black Window: Goá Phụ Đen', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'19', N'Actor', N'
Shang-Chi Và Huyền Thoại Thập Luân', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'poster_shangchi.jpg', N'Shang-Chi and The Legend of The Ten Rings', N'
Shang-Chi Và Huyền Thoại Thập Luân', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'2', N'Actor', N'Black Window: Goá Phụ Đen', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'black_widow.jpg', N'Black Window', N'
Black Window: Goá Phụ Đen', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'20', N'Actor', N'Black Window: Goá Phụ Đen', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'black_widow.jpg', N'Black Window', N'
Black Window: Goá Phụ Đen', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'21', N'Actor', N'
Shang-Chi Và Huyền Thoại Thập Luân', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'poster_shangchi.jpg', N'Shang-Chi and The Legend of The Ten Rings', N'
Shang-Chi Và Huyền Thoại Thập Luân', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'22', N'Actor', N'Black Window: Goá Phụ Đen', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'black_widow.jpg', N'Black Window', N'
Black Window: Goá Phụ Đen', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'24', N'Actor', N'Black Window: Goá Phụ Đen', N'Chuong', 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'4.jpg', N'Black Window', N'Black Window: Goá Phụ Đen', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'25', N'Actor', N'Black Window: Goá Phụ Đen', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'black_widow.jpg', N'Black Window', N'
Black Window: Goá Phụ Đen', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'3', N'Actor', N'
Shang-Chi Và Huyền Thoại Thập Luân', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'poster_shangchi.jpg', N'Shang-Chi and The Legend of The Ten Rings', N'
Shang-Chi Và Huyền Thoại Thập Luân', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'4', N'Actor', N'Black Window: Goá Phụ Đen', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'black_widow.jpg', N'Black Window', N'
Black Window: Goá Phụ Đen', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'5', N'Actor', N'
Shang-Chi Và Huyền Thoại Thập Luân', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'poster_shangchi.jpg', N'Shang-Chi and The Legend of The Ten Rings', N'
Shang-Chi Và Huyền Thoại Thập Luân', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'6', N'Actor', N'Black Window: Goá Phụ Đen', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'black_widow.jpg', N'Black Window', N'
Black Window: Goá Phụ Đen', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'7', N'Actor', N'
Shang-Chi Và Huyền Thoại Thập Luân', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'poster_shangchi.jpg', N'Shang-Chi and The Legend of The Ten Rings', N'
Shang-Chi Và Huyền Thoại Thập Luân', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'8', N'Actor', N'Black Window: Goá Phụ Đen', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'black_widow.jpg', N'Black Window', N'
Black Window: Goá Phụ Đen', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'9', N'Actor', N'
Shang-Chi Và Huyền Thoại Thập Luân', NULL, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), N'poster_shangchi.jpg', N'Shang-Chi and The Legend of The Ten Rings', N'
Shang-Chi Và Huyền Thoại Thập Luân', N'Movie Theater', NULL, NULL, CAST(N'2021-12-02T00:00:00.000' AS DateTime), N'1', 1)
GO
INSERT [movie_theater].[movie] ([movie_id], [actor], [content], [director], [duration], [from_date], [large_image], [movie_name_english], [movie_name_vn], [movie_product_company], [release_date], [small_image], [to_date], [version], [cinema_room_id]) VALUES (N'G3_uczOHFm', N'ChuongDepTrai', N'sdfsdfsdfsdf', N'sfsdfs', 11111, CAST(N'2021-12-01T00:00:00.000' AS DateTime), N'/resources/img/movie/4.jpg', N'SpiderMan', N'NhenNho', N'sdfsfs', CAST(N'2021-12-01T00:00:00.000' AS DateTime), NULL, CAST(N'2021-12-23T00:00:00.000' AS DateTime), N'sfsdfsd', 4)
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (1, N'1')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (2, N'1')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (3, N'1')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (4, N'1')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (5, N'1')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (8, N'1')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (9, N'1')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (12, N'1')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (7, N'14')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (7, N'2')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (8, N'2')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (9, N'2')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (10, N'2')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (11, N'2')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (1, N'24')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (10, N'3')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (11, N'3')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (12, N'3')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (7, N'4')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (10, N'4')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (11, N'5')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (12, N'5')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (8, N'6')
GO
INSERT [movie_theater].[movie_schedule] ([schedule_schedule_id], [movie_movie_id]) VALUES (1, N'G3_uczOHFm')
GO
SET IDENTITY_INSERT [movie_theater].[show_dates] ON
GO
INSERT [movie_theater].[show_dates] ([show_date_id], [date_name], [show_date]) VALUES (1, N'Date1', CAST(N'2021-12-21T00:00:00.000' AS DateTime))
GO
INSERT [movie_theater].[show_dates] ([show_date_id], [date_name], [show_date]) VALUES (2, N'Date2', CAST(N'2021-12-22T00:00:00.000' AS DateTime))
GO
INSERT [movie_theater].[show_dates] ([show_date_id], [date_name], [show_date]) VALUES (3, N'Date3', CAST(N'2021-12-23T00:00:00.000' AS DateTime))
GO
INSERT [movie_theater].[show_dates] ([show_date_id], [date_name], [show_date]) VALUES (4, N'Date4', CAST(N'2021-12-24T00:00:00.000' AS DateTime))
GO
INSERT [movie_theater].[show_dates] ([show_date_id], [date_name], [show_date]) VALUES (5, N'Date5', CAST(N'2021-12-25T00:00:00.000' AS DateTime))
GO
INSERT [movie_theater].[show_dates] ([show_date_id], [date_name], [show_date]) VALUES (6, N'Date6', CAST(N'2021-12-26T00:00:00.000' AS DateTime))
GO
INSERT [movie_theater].[show_dates] ([show_date_id], [date_name], [show_date]) VALUES (7, N'Date7', CAST(N'2021-12-27T00:00:00.000' AS DateTime))
GO
SET IDENTITY_INSERT [movie_theater].[show_dates] OFF
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'1', 1)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'1', 2)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'1', 3)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'14', 1)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'14', 2)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'14', 3)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'2', 2)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'2', 3)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'2', 4)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'24', 1)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'24', 2)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'24', 3)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'3', 1)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'3', 4)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'4', 2)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'4', 3)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'4', 6)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'4', 7)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'5', 1)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'5', 2)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'5', 5)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'6', 1)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'7', 7)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'G3_uczOHFm', 2)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'G3_uczOHFm', 3)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'G3_uczOHFm', 4)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'G3_uczOHFm', 5)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'G3_uczOHFm', 6)
GO
INSERT [movie_theater].[movie_date] ([movie_movie_id], [show_dates_show_date_id]) VALUES (N'G3_uczOHFm', 7)
GO
INSERT [movie_theater].[type] ([type_id], [type_name]) VALUES (1, N'Phim Hành Động')
GO
INSERT [movie_theater].[type] ([type_id], [type_name]) VALUES (2, N'Phim Tình Cảm')
GO
INSERT [movie_theater].[type] ([type_id], [type_name]) VALUES (3, N'Phim Chiến Tranh')
GO
INSERT [movie_theater].[type] ([type_id], [type_name]) VALUES (4, N'Phim Hài Hước')
GO
INSERT [movie_theater].[type] ([type_id], [type_name]) VALUES (5, N'Phim Viễn Tưởng')
GO
INSERT [movie_theater].[type] ([type_id], [type_name]) VALUES (6, N'Phim Hoạt Hình')
GO
INSERT [movie_theater].[type] ([type_id], [type_name]) VALUES (7, N'Phim Kinh Dị')
GO
INSERT [movie_theater].[type] ([type_id], [type_name]) VALUES (8, N'Phim Tâm Lý')
GO
INSERT [movie_theater].[type] ([type_id], [type_name]) VALUES (9, N'Phim Phiêu Lưu')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (1, N'1')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (1, N'10')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (5, N'11')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (1, N'12')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (5, N'13')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (1, N'14')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (5, N'15')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (1, N'16')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (5, N'17')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (1, N'18')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (5, N'19')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (5, N'2')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (1, N'20')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (5, N'21')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (1, N'22')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (1, N'24')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (1, N'3')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (5, N'4')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (1, N'5')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (5, N'5')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (1, N'6')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (5, N'7')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (1, N'8')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (5, N'9')
GO
INSERT [movie_theater].[movie_type] ([type_type_id], [movie_movie_id]) VALUES (1, N'G3_uczOHFm')
GO
INSERT [movie_theater].[employee] ([employee_id], [account_id]) VALUES (N'G3_0000001', N'G3_0000001')
GO
INSERT [movie_theater].[employee] ([employee_id], [account_id]) VALUES (N'G3_0000002', N'G3_0000002')
GO
INSERT [movie_theater].[employee] ([employee_id], [account_id]) VALUES (N'G3_0000003', N'G3_0000003')
GO
INSERT [movie_theater].[employee] ([employee_id], [account_id]) VALUES (N'G3_0000004', N'G3_0000004')
GO
INSERT [movie_theater].[employee] ([employee_id], [account_id]) VALUES (N'G3_0000005', N'G3_0000005')
GO
INSERT [movie_theater].[employee] ([employee_id], [account_id]) VALUES (N'G3_0000008', N'G3_0000008')
GO
INSERT [movie_theater].[invoice] ([invoice_id], [add_score], [booking_date], [movie_name], [schedule_show], [schedule_show_time], [seat], [status], [total_money], [use_score], [account_id]) VALUES (N'G3_VKq2EoG', 15000.0000, CAST(N'2021-12-21T00:00:00.000' AS DateTime), N'Black Window: Goá Phụ Đen', CAST(N'2021-12-21T00:00:00.000' AS DateTime), N'07:00', N'10A 10B 10C 10D 10E 10F ', 1, 110000.0000, 70000.0000, N'2')
GO
INSERT [movie_theater].[member] ([member_id], [score], [account_id]) VALUES (N'm122', 15000, N'2')
GO
SET IDENTITY_INSERT [movie_theater].[seat] ON
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (1, 30000, N'A', 1, 1, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (2, 20000, N'B', 1, 1, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (3, 30000, N'C', 1, 1, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (4, 40000, N'D', 1, 1, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (5, 30000, N'E', 1, 1, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (6, 30000, N'F', 1, 1, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (7, 30000, N'A', 2, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (8, 20000, N'B', 2, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (9, 30000, N'C', 2, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (10, 40000, N'D', 2, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (11, 30000, N'E', 2, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (12, 30000, N'F', 2, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (13, 30000, N'A', 3, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (14, 20000, N'B', 3, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (15, 30000, N'C', 3, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (16, 40000, N'D', 3, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (17, 30000, N'E', 3, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (18, 30000, N'F', 3, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (19, 30000, N'A', 4, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (20, 20000, N'B', 4, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (21, 30000, N'C', 4, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (22, 40000, N'D', 4, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (23, 30000, N'E', 4, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (24, 30000, N'F', 4, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (25, 30000, N'A', 5, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (26, 20000, N'B', 5, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (27, 30000, N'C', 5, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (28, 40000, N'D', 5, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (29, 30000, N'E', 5, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (30, 30000, N'F', 5, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (31, 30000, N'A', 6, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (32, 20000, N'B', 6, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (33, 30000, N'C', 6, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (34, 40000, N'D', 6, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (35, 30000, N'E', 6, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (36, 30000, N'F', 6, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (37, 30000, N'A', 7, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (38, 20000, N'B', 7, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (39, 30000, N'C', 7, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (40, 40000, N'D', 7, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (41, 30000, N'E', 7, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (42, 30000, N'F', 7, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (43, 30000, N'A', 8, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (44, 20000, N'B', 8, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (45, 30000, N'C', 8, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (46, 40000, N'D', 8, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (47, 30000, N'E', 8, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (48, 30000, N'F', 8, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (49, 30000, N'A', 9, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (50, 20000, N'B', 9, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (51, 30000, N'C', 9, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (52, 40000, N'D', 9, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (53, 30000, N'E', 9, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (54, 30000, N'F', 9, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (55, 30000, N'A', 10, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (56, 20000, N'B', 10, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (57, 30000, N'C', 10, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (58, 40000, N'D', 10, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (59, 30000, N'E', 10, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (60, 30000, N'F', 10, 0, 0, 1)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (61, 70000, N'B', 1, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (62, 70000, N'C', 1, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (63, 70000, N'D', 1, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (64, 70000, N'E', 1, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (65, 70000, N'F', 1, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (66, 70000, N'A', 1, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (67, 70000, N'B', 2, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (68, 140000, N'C', 2, 1, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (69, 140000, N'D', 2, 1, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (70, 140000, N'E', 2, 1, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (71, 140000, N'F', 2, 1, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (72, 70000, N'A', 2, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (73, 70000, N'B', 3, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (74, 70000, N'C', 3, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (75, 70000, N'D', 3, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (76, 70000, N'E', 3, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (77, 70000, N'F', 3, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (78, 70000, N'A', 3, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (79, 70000, N'B', 4, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (80, 70000, N'C', 4, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (81, 70000, N'D', 4, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (82, 70000, N'E', 4, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (83, 70000, N'F', 4, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (84, 70000, N'A', 4, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (85, 70000, N'B', 5, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (86, 70000, N'C', 5, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (87, 70000, N'D', 5, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (88, 70000, N'E', 5, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (89, 70000, N'F', 5, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (90, 70000, N'A', 5, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (91, 70000, N'B', 6, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (92, 70000, N'C', 6, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (93, 70000, N'D', 6, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (94, 70000, N'E', 6, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (95, 70000, N'F', 6, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (96, 70000, N'A', 6, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (97, 70000, N'B', 7, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (98, 70000, N'C', 7, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (99, 70000, N'D', 7, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (100, 70000, N'E', 7, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (101, 70000, N'F', 7, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (102, 70000, N'A', 7, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (103, 70000, N'B', 8, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (104, 70000, N'C', 8, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (105, 70000, N'D', 8, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (106, 70000, N'E', 8, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (107, 70000, N'F', 8, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (108, 70000, N'A', 8, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (109, 70000, N'B', 9, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (110, 70000, N'C', 9, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (111, 70000, N'D', 9, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (112, 70000, N'E', 9, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (113, 70000, N'F', 9, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (114, 70000, N'A', 9, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (115, 70000, N'B', 10, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (116, 70000, N'C', 10, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (117, 70000, N'D', 10, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (118, 70000, N'E', 10, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (119, 70000, N'F', 10, 0, 0, 8)
GO
INSERT [movie_theater].[seat] ([seat_id], [seat_price], [seat_column], [seat_row], [seat_type], [status], [cinema_room_id]) VALUES (120, 70000, N'A', 10, 0, 0, 8)
GO
SET IDENTITY_INSERT [movie_theater].[seat] OFF
GO
INSERT [movie_theater].[schedule_seat] ([schedule_seat_id], [movie_id], [schedule_id], [seat_column], [seat_id], [seat_row], [seat_type], [status], [invoice_id]) VALUES (N'G3__mkGspS', N'24', 1, NULL, 56, NULL, 0, 0, N'G3_VKq2EoG')
GO
INSERT [movie_theater].[schedule_seat] ([schedule_seat_id], [movie_id], [schedule_id], [seat_column], [seat_id], [seat_row], [seat_type], [status], [invoice_id]) VALUES (N'G3_h3oMhdq', N'24', 1, NULL, 58, NULL, 0, 0, N'G3_VKq2EoG')
GO
INSERT [movie_theater].[schedule_seat] ([schedule_seat_id], [movie_id], [schedule_id], [seat_column], [seat_id], [seat_row], [seat_type], [status], [invoice_id]) VALUES (N'G3_pbQLnTq', N'24', 1, NULL, 60, NULL, 0, 0, N'G3_VKq2EoG')
GO
INSERT [movie_theater].[schedule_seat] ([schedule_seat_id], [movie_id], [schedule_id], [seat_column], [seat_id], [seat_row], [seat_type], [status], [invoice_id]) VALUES (N'G3_q9yxi29', N'24', 1, NULL, 57, NULL, 0, 0, N'G3_VKq2EoG')
GO
INSERT [movie_theater].[schedule_seat] ([schedule_seat_id], [movie_id], [schedule_id], [seat_column], [seat_id], [seat_row], [seat_type], [status], [invoice_id]) VALUES (N'G3_S4ECEsh', N'24', 1, NULL, 59, NULL, 0, 0, N'G3_VKq2EoG')
GO
INSERT [movie_theater].[schedule_seat] ([schedule_seat_id], [movie_id], [schedule_id], [seat_column], [seat_id], [seat_row], [seat_type], [status], [invoice_id]) VALUES (N'G3_vnHa1n4', N'24', 1, NULL, 55, NULL, 0, 0, N'G3_VKq2EoG')
GO
SET IDENTITY_INSERT [movie_theater].[promotion] ON
GO
INSERT [movie_theater].[promotion] ([promotion_id], [detail], [discount_level], [end_time], [image], [start_time], [title]) VALUES (2, N'Merry Chrismas 50k', 50000, CAST(N'2021-12-31T00:00:00.000' AS DateTime), NULL, CAST(N'2021-12-20T00:00:00.000' AS DateTime), N'MC50')
GO
INSERT [movie_theater].[promotion] ([promotion_id], [detail], [discount_level], [end_time], [image], [start_time], [title]) VALUES (3, N'Merry Chrismas 100k', 100000, CAST(N'2021-12-25T00:00:00.000' AS DateTime), NULL, CAST(N'2021-12-24T00:00:00.000' AS DateTime), N'MC100')
GO
INSERT [movie_theater].[promotion] ([promotion_id], [detail], [discount_level], [end_time], [image], [start_time], [title]) VALUES (4, N'Happy New Year 10k', 10000, CAST(N'2022-01-10T00:00:00.000' AS DateTime), NULL, CAST(N'2021-12-29T00:00:00.000' AS DateTime), N'NY10')
GO
INSERT [movie_theater].[promotion] ([promotion_id], [detail], [discount_level], [end_time], [image], [start_time], [title]) VALUES (6, N'Happy New Year 50K', 50000, CAST(N'2022-01-05T00:00:00.000' AS DateTime), NULL, CAST(N'2021-12-29T00:00:00.000' AS DateTime), N'NY50')
GO
INSERT [movie_theater].[promotion] ([promotion_id], [detail], [discount_level], [end_time], [image], [start_time], [title]) VALUES (7, N'Happy New Year 100k', 100000, CAST(N'2022-01-02T00:00:00.000' AS DateTime), NULL, CAST(N'2021-12-31T00:00:00.000' AS DateTime), N'NY100')
GO
INSERT [movie_theater].[promotion] ([promotion_id], [detail], [discount_level], [end_time], [image], [start_time], [title]) VALUES (8, N'Lunar New Year 10k', 10000, CAST(N'2022-03-01T00:00:00.000' AS DateTime), NULL, CAST(N'2022-01-31T00:00:00.000' AS DateTime), N'LY10')
GO
INSERT [movie_theater].[promotion] ([promotion_id], [detail], [discount_level], [end_time], [image], [start_time], [title]) VALUES (13, N'detail', 1, CAST(N'2021-12-29T00:00:00.000' AS DateTime), N'/resources/img/promotion/dd01a3eb0d824b009c81e101065795c1.jpg', CAST(N'2021-12-08T00:00:00.000' AS DateTime), N'promotiontest1')
GO
SET IDENTITY_INSERT [movie_theater].[promotion] OFF
GO
SET IDENTITY_INSERT [movie_theater].[ticket] ON
GO
INSERT [movie_theater].[ticket] ([ticket_id], [price], [ticket_type]) VALUES (51, 30000.0000, 1)
GO
INSERT [movie_theater].[ticket] ([ticket_id], [price], [ticket_type]) VALUES (52, 20000.0000, 1)
GO
INSERT [movie_theater].[ticket] ([ticket_id], [price], [ticket_type]) VALUES (53, 30000.0000, 0)
GO
INSERT [movie_theater].[ticket] ([ticket_id], [price], [ticket_type]) VALUES (54, 30000.0000, 0)
GO
INSERT [movie_theater].[ticket] ([ticket_id], [price], [ticket_type]) VALUES (55, 20000.0000, 0)
GO
INSERT [movie_theater].[ticket] ([ticket_id], [price], [ticket_type]) VALUES (56, 30000.0000, 0)
GO
INSERT [movie_theater].[ticket] ([ticket_id], [price], [ticket_type]) VALUES (57, 20000.0000, 0)
GO
INSERT [movie_theater].[ticket] ([ticket_id], [price], [ticket_type]) VALUES (58, 30000.0000, 0)
GO
INSERT [movie_theater].[ticket] ([ticket_id], [price], [ticket_type]) VALUES (59, 40000.0000, 0)
GO
INSERT [movie_theater].[ticket] ([ticket_id], [price], [ticket_type]) VALUES (60, 30000.0000, 0)
GO
INSERT [movie_theater].[ticket] ([ticket_id], [price], [ticket_type]) VALUES (61, 30000.0000, 0)
GO
SET IDENTITY_INSERT [movie_theater].[ticket] OFF
GO
