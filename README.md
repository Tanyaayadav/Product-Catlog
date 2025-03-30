# **🛒 Product Catalog App**  

A modern Android app built using Jetpack Compose and MVVM architecture, designed to display products from DummyJSON API. This app fetches a list of products and displays details for each, including images, descriptions, categories, and prices.





# **📌 Features**  

### **1️⃣ Product List Screen (Home Screen)**  
✅ Displays a list of products with:  
- 🏷️ Product Title  
- 📝 Product Description  
- 🖼️ Product Image  

### **2️⃣ Product Detail Screen**  
✅ When a product is tapped, navigates to a detailed view showing:  
- 🏷️ Product Title  
- 🖼️ Product Images (Gallery/Carousel)  
- 📝 Product Description  
- ⭐ Product Rating  
- 📂 Product Category  
- 💰 Product Price  

---

# **⚙️ Tech Stack**  

- **Language:** Kotlin  
- **UI Framework:** Jetpack Compose  
- **Architecture:** MVVM (Model-View-ViewModel)  
- **Networking:** Retrofit  
- **State Management:** ViewModel + StateFlow  
- **Dependency Injection:** Hilt  
- **Navigation:** Jetpack Navigation  

---

# **🛠️ Setup Instructions**  

### **1️⃣ Prerequisites**  
Before running the app, ensure you have:  
✔ **Android Studio (Latest Version)** installed  
✔ **Android SDK 33+** installed  
✔ **Java 11+** installed  


2️⃣ Clone the Repository
      git clone https://github.com/your-username/ProductCatalogApp.git
      cd ProductCatalogApp

3️⃣ Open the Project in Android Studio
Open Android Studio
Click on File → Open
Select the cloned project directory

4️⃣ Build & Run the App
Connect an Android Emulator or Physical Device

Click Run ▶️ in Android Studio

#**📜 API Used**

This app fetches data from DummyJSON API:

Get all products: GET https://dummyjson.com/products

Get product by ID: GET https://dummyjson.com/products/{id}

#**🎯 Future Improvements**
🔹 Add pagination for product listing
🔹 Improve UI with animations & better layout
🔹 Add unit tests & UI tests

## 📸 App Screenshots

### Product List  



![Screenshot 2025-03-30 022944](https://github.com/user-attachments/assets/55a59e20-dbf5-4f90-b723-691f6ef702bb)

### Product Details



![Screenshot 2025-03-30 022955](https://github.com/user-attachments/assets/e4f95584-de91-4d12-a3b1-ffc65e7af1b7)
