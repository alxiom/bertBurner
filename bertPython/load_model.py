import torch
# import numpy as np

model = torch.jit.load("../scripted_model.pth")
x1 = torch.tensor([[1, 2, 3, 2, 3, 4]])
x2 = torch.tensor([[100, 200, 300]])
# x3 = torch.tensor([17000, 16000, 15000, 14000, 15000])

print(x1.shape)
print(x2.shape)
# print(x3.shape)

print(model(x1))
print(model(x2).data[0])
# print(np.argmax(model(x3).data[0]))
