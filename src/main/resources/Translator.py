from googletrans import Translator
f = open('SourceText.txt', 'r')
contents = f.read()
translator = Translator()
result = translator.translate(contents, dest='ru')
yt_txt = open('TranslatedText.txt', 'w')
yt_txt.write(result.text)
yt_txt.close()