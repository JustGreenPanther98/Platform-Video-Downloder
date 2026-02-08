🎯 Universal Video Downloader API
<br>
A powerful Spring Boot REST API for fetching high-quality download links from Facebook, Instagram, and YouTube.

🔗 Quick Links

>Live Documentation: <a href="https://platform-video-downloder.onrender.com/swagger-ui/index.html#/">Swagger UI</a>

Base Production URL: https://platform-video-downloder.onrender.com
<br>
📌 Features
Multi-Platform Support: Facebook, Instagram, and YouTube.

Smart Parsing: Handles Reels, Shorts, and long-form video links.

Dockerized Deployment: Automated builds via Multi-stage Dockerfile.

Error Handling: Global exception management for invalid links or API timeouts.

👉 API Endpoints
1) Facebook
>GET /api/v1/facebook/download

Note: Ensure your URL does not end with a end with /.

Example Body: {"url": "Your facebook URL here"}

2) Instagram
>GET /api/v1/instagram/reels/download?url={link}

3) YouTube
>GET /api/v1/youtube/download?url={link} (For long videos)

>GET /api/v1/youtube/shorts/download?url={link} (For shorts)

💫 Deployment on Render
