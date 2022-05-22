# AI_Adaptive_POW

To protect the client-server architecture from a Distributed Denial of Service (DDoS) attack we present AI Adaptive POW. The Proof Of Work (POW) framework is open-source, modular, and customizable. The framework has been developed using Java Springboot Framework and Python. AI Adaptive POW protects an
organization by injecting latency during communication. This is done by generating client reputation adaptive puzzles, which need to be solved by a client before the server begins processing a request. The framework adaptively tunes the difficulty of a puzzle based on a reputation score calculated by an AI model. The framework improves the defensive posture of an organization by slowing down the volume of incoming adversarial traffic. Additionally, the framework compels the adversary to incur a cost per connection, hence making it expensive for an adversary to sustain a volumetric DDoS attack.

# Steps to Run the System:

* Clone & Extract this Repository and Run Maven Build.

`Command to Run Maven Build: mvn spring-boot:run`

* Clone & Extract https://github.com/shaswata09/DabR 
* Download dependencies mentioned in requirements.txt

   `Command to Run the Server: python dabr.py`

   `Make sure the DabR server is hosted at 127.0.0.1:5000 port.`

* Open Swagger and test it with Desired valid IP and Chosen Policy.


    1. Note: Make sure to choose a policy from 1 to 3. Else default 1 will be chosen.
    2. Make sure to add https://ipinfo.io/ token in DabR code.

* That's All !

### Example Input: <br/>
    {
        "appliedPolicy": 2,
        "ip": "24.158.205.64"
    }

### Example Output:<br/>
    {
        "status": "success",
        "ip": "24.158.205.64",
        "reputation": 2.880635474986606,
        "randomString": "459100",
        "epsilon": "0.20000000298023224",
        "appliedPolicy": 2,
        "requiredHashResult": "cc12eec993b03508cb277e09e86fd547e48acac2f45c988a95bf570a772ad17f",
        "requiredBinaryResult": "0001101000011111001001010111000001011101011010100100111110100110101001100100011110101110101100011010011000111000111000100000011000000010011011011010001010110001010011100011011110001001001111001110111000101100110110000111011010010010000011100011101110111010",
        "startTime": "1652760374140",
        "endTime": "1652760374852",
        "elapsedTime": "712"
    }


#### Thank You. Any questions and suggestions are appreciated.


