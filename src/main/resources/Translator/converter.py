import moviepy.editor as mp
video = mp.VideoFileClip(r"src/main/resources/zoo.mp4")
video.audio.write_audiofile(r"src/main/resources/output.mp3")

