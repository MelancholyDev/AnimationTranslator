from moviepy.editor import *

clip1 = VideoFileClip(sys.argv[1])
clip1 = clip1.subclip(0,clip1.duration)
clip2 = clip1.resize(height=1920)
# getting width and height of clip 1
w2 = clip2.w
h2 = clip2.h
clip2.write_videofile(sys.argv[2])
print("Width x Height of clip 2 : ", end=" ")
print(str(w2) + " x ", str(h2))
print("---------------------------------------")