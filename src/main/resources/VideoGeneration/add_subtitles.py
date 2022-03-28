from moviepy.editor import *
import moviepy.video.tools.subtitles as subty
import moviepy

srt_file = sys.argv[1]
video_file = sys.argv[2]
final_file = sys.argv[3]

generator = lambda txt: TextClip(txt, font='Arial', fontsize=100, color='white')
subs = subty.file_to_subtitles(srt_file)
subtitles = moviepy.video.tools.subtitles.SubtitlesClip(subs, generator)
video = VideoFileClip(video_file)
result = CompositeVideoClip([video, subtitles.set_pos(('center','bottom'))])
result.write_videofile(final_file, fps=video.fps, temp_audiofile="temp-audio.m4a", remove_temp=True, codec="libx264", audio_codec="aac")
