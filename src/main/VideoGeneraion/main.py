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
is_add_subtitles = sys.argv[5] == '1'
va = sda.VideoAnimator(model_path=model_path)
vid, aud = va(image_path, audio_path)
va.save_video(vid, aud, save_video_path)

if (is_add_subtitles):
    clip1 = moviepy.VideoFileClip(save_video_path)
    clip1 = clip1.subclip(0,clip1.duration)
    clip2 = clip1.resize(height=1920)
    w2 = clip2.w
    h2 = clip2.h
    clip2.write_videofile('finaly.mp4')
    print("Width x Height of clip 2 : ", end=" ")
    print(str(w2) + " x ", str(h2))
    print("---------------------------------------")

    subtitles_path = sys.argv[6]
    generator = lambda txt: moviepy.video.VideoClip.TextClip(txt, font="Times-Roman", fontsize=24, color="White")
    subtitles = moviepy.video.tools.subtitles.SubtitlesClip(subs, generator)
    video = moviepy.video.io.VideoFileClip.VideoFileClip(save_video_path)
    final_path = save_video_path[:-4]
    final_path = final_path + '_subs.mp4'
    result = moviepy.video.compositing.CompositeVideoClip.CompositeVideoClip(
        [video, subtitles.set_pos(('center', 'bottom'))])
    result.write_videofile(final_path, fps=video.fps, temp_audiofile="temp-audio.m4a", remove_temp=True,
                           codec="libx264",
                           audio_codec="aac")
