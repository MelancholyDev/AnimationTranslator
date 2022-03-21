import sda
import sys
import moviepy.video.VideoClip
from moviepy.editor import *
import moviepy.video.compositing.CompositeVideoClip
import moviepy.video.tools.subtitles
import moviepy.video.io.VideoFileClip

model_path = sys.argv[1]
image_path = sys.argv[2]
audio_path = sys.argv[3]
save_video_path = sys.argv[4]
va = sda.VideoAnimator(model_path=model_path)
vid, aud = va(image_path, audio_path)
va.save_video(vid, aud, save_video_path)

# clip1 = VideoFileClip(save_video_path)
# clip1 = clip1.subclip(0, clip1.duration)
# clip2 = clip1.resize(height=1920)
# # getting width and height of clip 1
# w2 = clip2.w
# h2 = clip2.h
# clip2.write_videofile(sys.argv[5])
# print("Width x Height of clip 2 : ", end=" ")
# print(str(w2) + " x ", str(h2))
# print("---------------------------------------")
