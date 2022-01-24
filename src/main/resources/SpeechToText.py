import requests

filename = 'SourceFile.mp4'
f = open("api_key.txt", "r")
api_key = f.read()
def read_file(filename, chunk_size=5242880):
    with open(filename, 'rb') as _file:
        while True:
            data = _file.read(chunk_size)
            if not data:
                break
            yield data

headers = {'authorization': api_key}
response = requests.post('https://api.assemblyai.com/v2/upload',
                         headers=headers,
                         data=read_file(filename))

audio_url = response.json()['upload_url']




import requests

endpoint = "https://api.assemblyai.com/v2/transcript"

json = {
    "audio_url": audio_url
}

headers = {
    "authorization": api_key,
    "content-type": "application/json"
}

transcript_input_response = requests.post(endpoint, json=json, headers=headers)




transcript_id = transcript_input_response.json()["id"]


# 6. Retrieve transcription results
endpoint = f"https://api.assemblyai.com/v2/transcript/{transcript_id}"
headers = {
    "authorization": api_key,
}

transcript_output_response = requests.get(endpoint, headers=headers)


# Check if transcription is complete
from time import sleep

while transcript_output_response.json()['status'] != 'completed':
    sleep(5)
    print('Transcription is processing ...')
    transcript_output_response = requests.get(endpoint, headers=headers)


#print(transcript_output_response.json()["status"])


# 7. Save transcribed text
yt_txt = open('SourceText.txt', 'w')
yt_txt.write(transcript_output_response.json()["text"])
yt_txt.close()
print('END')