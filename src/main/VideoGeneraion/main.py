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

generator = lambda txt: moviepy.video.VideoClip.TextClip(txt, font="Times-Roman", fontsize=24, color="White")

subs = [((0, 4), 'subs1'),
((4, 9), 'subs2'),
((9, 12), 'subs3'),
((12, 16), 'subs4')]

subtitles = moviepy.video.tools.subtitles.SubtitlesClip(subs, generator)

video = moviepy.video.io.VideoFileClip.VideoFileClip("generated.mp4")
result = moviepy.video.compositing.CompositeVideoClip.CompositeVideoClip([video, subtitles.set_pos(('center', 'bottom'))])

result.write_videofile("output.mp4", fps=video.fps, temp_audiofile="temp-audio.m4a", remove_temp=True, codec="libx264",
audio_codec="aac")