# SimpleNettyServer
### INFO 

Hi, this is a simple example of a client-server application in java netty. This example is aimed at beginners in netty who cannot find understandable material on the Internet. If you still have any questions, please contact me and I will try to help you.

### WARNINGS 
- The  `Packet` class on the client and on the server must be identical, otherwise the application will not work. For example, if the classes are the same, but the package names are different, then the application will not work. In my example, the `Packet` class is available to the client and the server, since they are on the same device in the same project, but if we are talking about different devices, then **BE CAREFUL** that the Packet class on both devices is identical.
