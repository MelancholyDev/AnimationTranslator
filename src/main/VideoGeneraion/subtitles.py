from moviepy.editor import *
import moviepy.video.tools.subtitles as subty


srt_file = sys.argv[1]
final_library = sys.argv[2]
final_name = sys.argv[3]

generator = lambda txt: TextClip(txt, font='Arial', fontsize=100, color='white')
subs = subty.file_to_subtitles("output.srt")
subtitles = moviepy.video.tools.subtitles.SubtitlesClip(subs, generator)
video = VideoFileClip("finaly.mp4")
result = CompositeVideoClip([video, subtitles.set_pos(('center','bottom'))])
result.write_videofile("output.mp4", fps=video.fps, temp_audiofile="temp-audio.m4a", remove_temp=True, codec="libx264", audio_codec="aac")