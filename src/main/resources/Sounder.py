import pyttsx3

tts = pyttsx3.init()
voices = tts.getProperty('voices')
tts.setProperty('voice', voices[0].id)
tts.setProperty("rate", 250)
f = open('TranslatedText.txt', 'r')
text = f.read()
tts.save_to_file(text, "SoundedText.mp3")
tts.runAndWait()