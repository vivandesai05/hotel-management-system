# 🏨 Hotel Management System

A full-featured Hotel Management System built to manage hotel operations including reservations, room management, billing, and customer management. The project aims to simplify hotel workflows and provide a clean, intuitive interface for both staff and administrators.

---

## 🔧 Features

- ✅ Room Booking & Availability Check
- 🛏️ Room Category Management (Standard, Deluxe, Suite)
- 👥 Customer Check-in / Check-out
- 📜 Billing and Invoice Generation
- 📊 Admin Dashboard with Reports
- 📩 Email Notifications (optional)
- 🔐 Role-Based Access (Admin, Receptionist)
- 📁 CRUD operations for Rooms, Customers, Bookings

---

### Installation

```bash
# Clone the repository
git clone https://github.com/yourusername/hotel-management-system.git
cd hotel-management-system

# Create a virtual environment (Python)
python -m venv venv
source venv/bin/activate  # On Windows: venv\Scripts\activate

# Install dependencies
pip install -r requirements.txt

# Apply migrations
python manage.py migrate

# Run the server
python manage.py runserver
