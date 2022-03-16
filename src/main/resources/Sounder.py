import pyttsx3

tts = pyttsx3.init()
voices = tts.getProperty('voices')
tts.setProperty('voice', voices[0].id)
tts.setProperty("rate", 160)
f = open('src/main/resources/TranslatedText/tramp_innoguration_translated.txt', 'r')
text = f.read()
tts.save_to_file(text, "src/main/resources/SoundedText/tramp_innoguration_sounded.wav")
tts.runAndWait()