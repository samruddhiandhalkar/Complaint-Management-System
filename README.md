# Complaint-Management-System
Online Complaint Management System is a digital platform designed to help users or citizens register their complaints easily through an online interface. It allows users to submit their complaints by filling out a simple form with details such as name, email, subject, and description. Once submitted, the complaint is forwarded to the concerned authority for review and resolution. This system replaces traditional paper-based processes, saving time and improving efficiency. It also increases transparency and ensures better tracking and faster resolution of issues. Such systems are useful in schools, colleges, government offices, and private organizations.

🔑 Key Features:

📝 1. Complaint Registration
* Users can submit complaints through an online form
* Fields: Name, Email, Subject, Description

📥 2. Complaint Storage
* Complaints are saved in a PostgreSQL database
* Each complaint has a unique ID and timestamp

🗃️ 3. Backend with REST API
* Built using Spring Boot REST API
* Endpoints to:
     * Submit a complaint
       * Get all complaints
* (Optional) Get complaint by ID or delete complaint

🌐 4. Frontend Integration:
* Form created using HTML, CSS, JavaScript
* Responsive design for mobile and desktop
* Connected to backend using fetch() API or AJAX

🛡️ 5. CORS Configuration:
* Allows frontend (e.g., running on port 5032) to communicate with backend (e.g., port 9092)

✅ 6. Validation & Error Handling:
* Form fields have validation (required fields, email format, etc.)
* Backend returns meaningful error messages if something fails
* Handles "Failed to fetch", "Internal Server Error", etc.

💾 7. MVC Architecture:
* Project follows Model-View-Controller (MVC) pattern
* Model: Complaint Entity
* Controller: ComplaintController
* Service & Repository layers for logic and DB access

