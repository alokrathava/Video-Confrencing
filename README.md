# Video-Confrencing
#Video Confrencing App Using Jitsi Library

#Jitsi Library

1. build.gradle (Project Video_Confrencing)
 maven {
            url "https://github.com/jitsi/jitsi-maven-repository/raw/master/releases"
        }

2. build.gradle (Module: Video_Confrencing.app)
 // Jitsi Meet
    implementation ('org.jitsi.react:jitsi-meet-sdk:3.0.0') { transitive = true }
