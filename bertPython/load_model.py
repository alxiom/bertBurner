import torch
# import numpy as np

model = torch.jit.load("../scripted_model.pth")
x1 = torch.tensor([[1, 2, 3]])
x2 = torch.tensor([[100, 200]])
x3 = torch.tensor([[17000, 16000, 15000, 14000, 15000]])
x4 = torch.tensor([[100, 201]])

print(f"{model(x1).data[0][1]:.8f}")
print(f"{model(x2).data[0][1]:.8f}")
print(f"{model(x3).data[0][1]:.8f}")
print(f"{model(x4).data[0][1]:.8f}")

