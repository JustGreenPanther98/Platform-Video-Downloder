🎯 <b>Universal Video Downloader API</b>
<br>
A powerful Spring Boot REST API for fetching high-quality download links from Facebook, Instagram, and YouTube.

🔗 <b>Quick Links</b>

>Live Documentation: <a href="https://platform-video-downloder.onrender.com/swagger-ui/index.html#/">Swagger UI</a>

Base Production URL: https://platform-video-downloder.onrender.com
<br>

📌 <b>Features</b>

1) Multi-Platform Support: Facebook, Instagram, and YouTube.

2) Smart Parsing: Handles Reels, Shorts, and long-form video links.
   
3) Error Handling: Global exception management for invalid links or API timeouts.

👉 <b>API Endpoints</b>

1) Facebook
>POST /api/v1/facebook/download

Note: Ensure your URL does not end with a end with /.
Example Body: {"url": "Your facebook URL here"}

2) Instagram

>GET /api/v1/instagram/reels/download?url={link}

3) YouTube

>GET /api/v1/youtube/download?url={link} (For long videos)

>GET /api/v1/youtube/shorts/download?url={link} (For shorts)
