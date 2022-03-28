import sda
import sys
import moviepy.video.VideoClip
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
