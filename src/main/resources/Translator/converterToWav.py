from pydub import AudioSegment
sound = AudioSegment.from_mp3("src/main/resources/output.mp3.mp3")
sound.export("src/main/resources/result.wav", format="wav")