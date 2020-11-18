def buildOrder(projects, dependencies):
	projectToId = {projects[i]:i for i in range(len(projects))}
	n = len(projects)
	in_neighbors = [set() for i in range(n)]
	out_neighbors = [set() for i in range(n)]
	result = []
	remaining = set(projects)
	for a, b in dependencies:
		out_neighbors[projectToId[a]].add(projectToId[b])
		in_neighbors[projectToId[b]].add(projectToId[a])
	last_iteration_size = len(remaining)
	while (len(remaining) > 0):
		for project in set(remaining):
			if len(in_neighbors[projectToId[project]]) == 0:
				result.append(project)
				remaining.remove(project)
				for out_neighbor in out_neighbors[projectToId[project]]:
					in_neighbors[out_neighbor].remove(projectToId[project])
		if (len(remaining) == last_iteration_size):
			return "dependency cycle"
		last_iteration_size = len(remaining)
	return result

print(buildOrder(["a", "b", "c", "d", "e", "f"], [("a", "d"), ("f", "b"), ("b", "d"), ("f", "a"), ("d", "c")]))
