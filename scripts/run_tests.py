# list all subdirectories in the current directory

import os
import subprocess
from typing import List


def _get_all_dirs(cur_dir: List[str], path: str, all_tests: List[str]) -> None:
    BLACK_LIST = ['src/test', 'src/temp']
    for black_list_word in BLACK_LIST:
        if path.startswith(black_list_word):
            return

    for dir in cur_dir:
        files = []
        is_test = False
        for subdir in os.listdir(dir):
            full_path = os.path.join(dir, subdir)
            if os.path.isdir(full_path):
                files.append(full_path)
            elif subdir == 'MainTest.java':
                is_test = True

        if len(files) == 0:
            # check if a file named MainTets.java in this
            if is_test:
                # if exists, add to the list of tests and return whole thing
                all_tests.append(path[4:] + dir.split('/')[-1])

        _get_all_dirs(files, path + dir.split('/')[-1] + '.', all_tests)


def get_all_tests() -> List[str]:
    all_tests = []

    # set the starting directory to src/
    cur_dir = [os.path.join(os.getcwd(), 'src')]

    # start recursively
    _get_all_dirs(cur_dir, '', all_tests)
    return all_tests


def main() -> None:
    all_tests = get_all_tests()
    # get dirs
    for test in all_tests:
        dirs = os.path.join('src', '/'.join(test.split('.')))
        # get all files in that directory
        print(dirs)
        subprocess.call(['javac', '-d', os.path.join(os.getcwd(), 'bin'), '-cp', 'lib/*',
                        '-sourcepath', os.path.join(os.getcwd(), 'src'), os.path.join(dirs, 'MainTest.java')])
        # run the test
        subprocess.call(['java', '-jar', 'lib/junit-platform-console-standalone-1.9.0.jar', '--class-path',
                        'bin', '-c', test + '.MainTest', '--reports-dir', os.path.join('reports', dirs[4:])])


if __name__ == '__main__':
    main()
