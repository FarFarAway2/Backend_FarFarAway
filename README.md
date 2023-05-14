# *Backend_FarFarAway*
##### Far Far Away is a web platform for thematic travel offers, focused on adventurous and medieval type experiences, among others. Its main objective is to provide users with a variety of travel options that match their specific interests and preferences.

The application offers the following functionalities and features:

1. **Hotel booking**: users can search and book hotels for their trip, with the ability to view details, such as availability, location, prices and services.

2. **Hotel management**: System administrators have access to hotel management functionalities, such as adding new hotels, updating information, managing availability and deleting hotels.

3. **Hotel offers**: Users can explore and access special offers from themed hotels, such as medieval or adventurous offers, which provide exclusive discounts and additional benefits.

4. **User roles**: The application supports user roles, which means that different permissions and access levels can be assigned to users according to their role or responsibility.

5. **Travel booking**: Users can search for and book themed travel packages, such as adventurous or medieval trips, which include accommodation, activities and experiences related to the selected theme.

6. **Trip management**: Administrators can manage available trips, add new themed trips, update details and manage availability of dates and quotas.

7. **Travel offers**: Special offers and discounts are provided for themed travel packages, giving users the opportunity to obtain attractive themed experiences at lower prices.

##### In short, the app is a web platform that allows users to discover, book and enjoy themed travel deals, especially focused on adventurous and medieval experiences. It provides a convenient way to explore options, make reservations and take advantage of exclusive offers for unique and memorable travel experiences.

------------
### ***Technical features***

##### *controller package*

1. **HotelBookController**:
   - Handles HTTP requests related to hotel reservations.
   - It contains methods to list all hotel reservations, save a new reservation, get a reservation by its ID, update an existing reservation and delete a reservation.

2. **HotelManageController**:
   - Manages HTTP requests related to hotel management.
   - It provides methods to list all managed hotels, save a new managed hotel, get a managed hotel by its ID, update an existing managed hotel, and delete a managed hotel.

3. **HotelOfferController**:
   - Controls HTTP requests related to hotel offers.
   - It includes methods to list all hotel offers, save a new offer, get an offer by its ID, update an existing offer, and delete an offer.

4. **RolesController**:
   - Manages HTTP requests related to user roles.
   - It contains methods to list all roles, save a new role, get a role by its ID, update an existing role and delete a role.

5. **TravelBookController**:
   - Handles HTTP requests related to travel booking.
   - Provides methods to list all travel bookings, save a new booking, get a booking by its ID, update an existing booking and delete a booking.

6. **TravelManageController**:
   - Controls HTTP requests related to travel management.
   - It includes methods to list all managed trips, save a new managed trip, get a managed trip by its ID, update an existing managed trip, and delete a managed trip.

7. **UsersController**:
   - Handles HTTP requests related to users.
   - Contains methods to list all users, save a new user, get a user by ID, update an existing user and delete a user.

8. **TravelOfferController**:
   - Controls HTTP requests related to travel offers.
   - It includes methods to list all travel offers, save a new offer, get an offer by its ID, update an existing offer and delete an offer.

##### *dto Package*

1. **HotelBook**: 
 - Represents a hotel reservation. Contains references to a user and a hotel offer, indicating that a user has booked a specific hotel offer.

2. **HotelManage**: 
 - Represents the management of a hotel offer. Contains references to a user and a hotel offer, indicating that a specific user is managing a hotel offer.

3. **HotelOffer**: 
 - Represents a hotel offer. It contains attributes such as price, description, hotel name and image. It also maintains a list of the reservations and the management of the offer.

4. **Roles**: 
 - Represents a user role. It contains a name for the role. This model could be used in an authorization system.

5. **TravelBook**: 
 - Same as HotelBook, but for travel offers. Indicates that a user has booked a specific travel offer.

6. **TravelManage**: 
 - Same as HotelManage, but for travel offers. Indicates that a specific user is managing a travel offer.

7. **TravelOffer**:
 - Represents a travel offer. Like HotelOffer, it contains details of the offer and maintains a list of bookings and offer management.

8. **UserRole**: 
 - Associates a user with a role. It is useful to implement a system of roles and permissions.

9. **Users**: 
 - Represents a user in the system. Contains user information such as name, email, password, and more. It also maintains lists of hotel and travel offers, and the managements and reservations that the user has made.

------------


[ER Model and Relational Model](https://github.com/DracoBlasterZ/Backend_FarFarAway/blob/main/ModER_ModRel.jpg "ER Model and Relational Model")

