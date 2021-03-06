# Navigation-Trainer
An immersive journey preparation tool for people with vision impairment

In the process of building a proof of concept in a variety of platforms, an Android application was developed, allowing users to experience immersive spatial audio recorded in different locations on Flinders Street Station. The application is capable of changing soundfield using hardware-based sensors which are physical components built into a handset or tablet device. Specifically, data is extracted from the geomagnetic field sensor in combination with the accelerometer using android sensor API to determine a device's position relative to the magnetic north pole, this orientation data in quaternion format is then passed through Google VR audio engine to rotate Ambisonic soundfield.

The Google VR audio engine allows the user to spatialize sound sources in 3D space, including distance and height cues. The GvrAudioEngine is capable of playing back spatial sound in two separate ways: Sound Object rendering, allows the user to create a virtual sound source in 3D space, the second method allows the user to play back Ambisonic soundfield. The first method was used to create artifical directional audio narration of surrounding environment and objects, the second method was used to playback ambisonic audio files recorded in real-time using Sennheiser Ambeo VR Microphone.

